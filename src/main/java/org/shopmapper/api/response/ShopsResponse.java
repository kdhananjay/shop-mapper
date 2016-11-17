package org.shopmapper.api.response;

import org.shopmapper.rest.model.ShopAddress;

public class ShopsResponse {
  private String shopName;
  private ShopAddress shopAddress;
  private double shopLongitude;
  private double shopLatitude;

  /**
   * @return shopsName.
   */
  public String getShopsName() {
    return shopName;
  }

  /**
   * @param shopsName the shopsName to set.
   */
  public void setShopsName(String shopsName) {
    this.shopName = shopsName;
  }

  /**
   * @return shopAddress.
   */
  public ShopAddress getShopAddress() {
    return shopAddress;
  }

  /**
   * @param shopAddress the shopAddress to set.
   */
  public void setShopAddress(ShopAddress shopAddress) {
    this.shopAddress = shopAddress;
  }

  /**
   * @return shopLongitude.
   */
  public double getShopLongitude() {
    return shopLongitude;
  }

  /**
   * @param shopLongitude the shopLongitude to set.
   */
  public void setShopLongitude(double shopLongitude) {
    this.shopLongitude = shopLongitude;
  }

  /**
   * @return shopLatitude.
   */
  public double getShopLatitude() {
    return shopLatitude;
  }

  /**
   * @param shopLatitude the shopLatitude to set.
   */
  public void setShopLatitude(double shopLatitude) {
    this.shopLatitude = shopLatitude;
  }
}
