package org.shopmapper.rest.bs;

import org.shopmapper.api.request.ShopRequest;
import org.shopmapper.rest.model.ShopGeoInfo;
import org.shopmapper.rest.model.ShopInfo;

import java.util.Collection;
import java.util.List;


public interface ShopMapper {
  public ShopInfo addShop(ShopRequest shopRequest);

  public List<ShopInfo> getShops(ShopGeoInfo shopGeoInfo);

  public Collection<ShopInfo> getAll();
}
