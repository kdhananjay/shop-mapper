package org.shopmapper.api;

import org.shopmapper.api.request.ShopRequest;
import org.shopmapper.api.response.ShopsResponse;
import org.shopmapper.rest.bs.ShopMapper;
import org.shopmapper.rest.model.ShopGeoInfo;
import org.shopmapper.rest.model.ShopInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
public class ShopMapperController implements IShopMapperController {
  private static final Logger logger = LoggerFactory.getLogger(ShopMapperController.class);
  @Autowired
  private ShopMapper shopMapper;



  @Override
  public ResponseEntity<ShopsResponse> addShop(@RequestBody ShopRequest shopRequest) {
    logger.info("Request recevied for addShop  : " + shopRequest);
    shopRequest.print();
    ShopInfo shopInfo = shopMapper.addShop(shopRequest);
    ShopsResponse shops = mapShops(shopInfo);
    return new ResponseEntity<ShopsResponse>(shops, HttpStatus.CREATED);
  }



  @Override
  public ResponseEntity<Collection<ShopsResponse>> getShops(Float customerLongitude,
      Float customerLatitude, Integer all) {
    logger.info("Requst received for getShops");
    Collection<ShopInfo> shops = null;
    if (all != null && all.intValue() == 1) {
      logger.info("Loading all data...");
      shops = shopMapper.getAll();
    } else {
      logger.info("Loading search data...");
      ShopGeoInfo shopGeoInfo = new ShopGeoInfo();

      shopGeoInfo.setShopLatitude(customerLatitude);
      shopGeoInfo.setShopLongitude(customerLongitude);
      shops = shopMapper.getShops(shopGeoInfo);
    }

    List<ShopsResponse> shopsList = null;
    if (shops != null) {
      for (ShopInfo shopInfo : shops) {
        if (shopsList == null) {
          shopsList = new ArrayList<ShopsResponse>();
        }
        shopsList.add(mapShops(shopInfo));
      }
    }
    if (shopsList != null) {
      logger.info("Total shops count :" + shopsList.size());
      return new ResponseEntity<Collection<ShopsResponse>>(shopsList, HttpStatus.OK);
    } else {
      logger.info("We didn't find any shops.");
      return new ResponseEntity<Collection<ShopsResponse>>(shopsList, HttpStatus.NO_CONTENT);
    }
  }



  private ShopsResponse mapShops(ShopInfo shopInfo) {
    ShopsResponse shop = new ShopsResponse();
    shop.setShopAddress(shopInfo.getShopAddress());
    shop.setShopsName(shopInfo.getShopName());
    shop.setShopLatitude(shopInfo.getShopGeoInfo().getShopLatitude());
    shop.setShopLongitude(shopInfo.getShopGeoInfo().getShopLongitude());
    return shop;
  }

}
