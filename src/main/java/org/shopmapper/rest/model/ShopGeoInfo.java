package org.shopmapper.rest.model;

public class ShopGeoInfo {
  private double shopLongitude;
  private double shopLatitude;

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
   * @param lat the shopLatitude to set.
   */
  public void setShopLatitude(double lat) {
    this.shopLatitude = lat;
  }

  @Override
  public String toString() {
    return "lat : " + Double.toString(shopLatitude) + "\t lng :" + Double.toString(shopLongitude);

  }

}
