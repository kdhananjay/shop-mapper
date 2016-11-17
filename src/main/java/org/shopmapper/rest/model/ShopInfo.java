package org.shopmapper.rest.model;

import java.math.BigInteger;

public class ShopInfo {
  private BigInteger id;
  private String shopName;
  private ShopAddress shopAddress;
  private ShopGeoInfo shopGeoInfo;

  /**
   * @return id.
   */
  public BigInteger getId() {
    return id;
  }

  /**
   * @param id the id to set.
   */
  public void setId(BigInteger id) {
    this.id = id;
  }

  /**
   * @return shopName.
   */
  public String getShopName() {
    return shopName;
  }

  /**
   * @param shopName the shopName to set.
   */
  public void setShopName(String shopName) {
    this.shopName = shopName;
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
   * @return shopGeoInfo.
   */
  public ShopGeoInfo getShopGeoInfo() {
    return shopGeoInfo;
  }

  /**
   * @param shopGeoInfo the shopGeoInfo to set.
   */
  public void setShopGeoInfo(ShopGeoInfo shopGeoInfo) {
    this.shopGeoInfo = shopGeoInfo;
  }

}
