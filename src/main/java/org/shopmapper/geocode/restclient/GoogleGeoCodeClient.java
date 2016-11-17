package org.shopmapper.geocode.restclient;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import org.shopmapper.api.request.ShopRequest;
import org.shopmapper.rest.model.ShopAddress;
import org.shopmapper.rest.model.ShopGeoInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dhananjay Kumar.
 *
 *         This can also use WebTarget approach to access rest endpoints, but as we have client
 *         library exposed, it will help to get response POJO, if we use WebTarget, we need to
 *         define and map POJO based on response JSON string.
 */
@Component
public class GoogleGeoCodeClient implements IGoogleGeoCodeClient {

  private static final Logger logger = LoggerFactory.getLogger(GoogleGeoCodeClient.class);

  @Autowired
  GoogleKey googleKey;

  @Override
  public ShopGeoInfo getShopGeoInfo(ShopRequest shopRequest) {
    ShopAddress shopAddress = shopRequest.getShopAddress();
    logger.info("Google key is :" + googleKey.getKey());
    GeoApiContext context = new GeoApiContext().setApiKey(googleKey.getKey());
    try {
      ComponentFilter filters = ComponentFilter.postalCode(shopAddress.getPostCode());
      GeocodingApiRequest geocodingApiRequest = GeocodingApi.newRequest(context)
          .address(Integer.toString(shopAddress.getNumber()) + " " + shopRequest.getShopName())
          .components(filters);
      GeocodingResult[] geocodingResults = geocodingApiRequest.await();

      if (geocodingResults.length <= 0) {
        logger.error("Google API Error : not result recieved.");
        return null;
      }

      for (GeocodingResult result : geocodingResults) {
        for (AddressComponent address : result.addressComponents) {
          logger.info("address :" + address.longName + "\t type :" + address.types.toString());

          for (AddressComponentType type : address.types) {
            if (type == AddressComponentType.POSTAL_CODE
                && address.longName.equalsIgnoreCase(shopAddress.getPostCode())) {
              ShopGeoInfo shopGeoInfo = new ShopGeoInfo();
              shopGeoInfo.setShopLatitude(result.geometry.location.lat);
              shopGeoInfo.setShopLongitude(result.geometry.location.lng);
              return shopGeoInfo;
            }
          }
        }
      }
    } catch (Exception exception) {
      logger.error("Google API exception : " + exception.getMessage());
    }
    return null;
  }

  @Override
  public String getPostalCode(ShopGeoInfo shopGeoInfo) {
    // Replace the Google API key with a valid API key.
    GeoApiContext context = new GeoApiContext().setApiKey(googleKey.getKey());
    try {
      LatLng location = new LatLng(shopGeoInfo.getShopLatitude(), shopGeoInfo.getShopLongitude());
      GeocodingResult[] geocodingResults = GeocodingApi.reverseGeocode(context, location).await();
      if (geocodingResults == null || geocodingResults.length < 1) {
        return null;
      }
      for (GeocodingResult geocodingResult : geocodingResults) {
        logger.info(geocodingResult.formattedAddress);
        for (AddressComponent addressComponet : geocodingResult.addressComponents) {
          for (AddressComponentType type : addressComponet.types) {
            if (type == AddressComponentType.POSTAL_CODE) {
              return addressComponet.longName;
            }
          }
        }
      }
    } catch (Exception exception) {
      logger.error("Google API excpetion : " + exception.getMessage());
    }

    return null;
  }

}
