package org.shopmapper.rest.model;

public class ShopAddress {
  private int number;
  private String postCode; // This require as postalCode can be alphanumeric

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  @Override
  public String toString() {
    return "number : " + number + "\t postCode :" + postCode;
  }
}
