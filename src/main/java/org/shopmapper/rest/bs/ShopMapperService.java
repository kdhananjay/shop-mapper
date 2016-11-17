package org.shopmapper.rest.bs;

import org.shopmapper.api.request.ShopRequest;
import org.shopmapper.geocode.restclient.IGoogleGeoCodeClient;
import org.shopmapper.rest.model.ShopGeoInfo;
import org.shopmapper.rest.model.ShopInfo;
import org.shopmapper.rest.repository.IShopsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class ShopMapperService implements ShopMapper {
  private static final Logger logger = LoggerFactory.getLogger(ShopMapperService.class);

  @Autowired
  private IShopsRepository shopsRepository;

  @Autowired
  IGoogleGeoCodeClient googleGeoCodeClient;

  @Override
  public ShopInfo addShop(ShopRequest shopRequest) {
    logger.info("addShop API called");
    ShopGeoInfo shopGeoInfo = googleGeoCodeClient.getShopGeoInfo(shopRequest);
    ShopInfo shopInfo = new ShopInfo();
    shopInfo.setShopName(shopRequest.getShopName());
    shopInfo.setShopAddress(shopRequest.getShopAddress());
    shopInfo.setShopGeoInfo(shopGeoInfo);
    shopInfo = shopsRepository.save(shopInfo);
    return shopInfo;
  }

  @Override
  public List<ShopInfo> getShops(ShopGeoInfo shopGeoInfo) {
    logger.info("getShops API called");
    String postalCode = googleGeoCodeClient.getPostalCode(shopGeoInfo);
    if (postalCode == null) {
      return null;
    }
    List<ShopInfo> shopsInfoList = shopsRepository.findAll(postalCode);
    return shopsInfoList;
  }

  @Override
  public Collection<ShopInfo> getAll() {
    List<ShopInfo> shopsInfoList = shopsRepository.findAll(null);
    return shopsInfoList;
  }

}
