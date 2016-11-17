package org.shopmapper.geocode.restclient;

import org.shopmapper.api.request.ShopRequest;
import org.shopmapper.rest.model.ShopGeoInfo;

/**
 * @author Dhananjay Kumar.
 *
 */
public interface IGoogleGeoCodeClient {
  /**
   * @param shopAddress.
   * @return ShopGeoInfo This return geo code based on postal code.
   */
  public ShopGeoInfo getShopGeoInfo(ShopRequest shopRequest);

  /**
   * @param shopGeoInfo.
   * @return String This return postal code of given geo code.
   */
  public String getPostalCode(ShopGeoInfo shopGeoInfo);
}
