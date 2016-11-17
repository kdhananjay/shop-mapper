package org.shopmapper.api.request;

import org.shopmapper.rest.model.ShopAddress;

public class ShopRequest {
  private String shopName;
  private ShopAddress shopAddress;

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public ShopAddress getShopAddress() {
    return shopAddress;
  }

  public void setShopAddress(ShopAddress shopAddress) {
    this.shopAddress = shopAddress;
  }

  public void print() {}
}
