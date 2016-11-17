package org.shopmapper.api;

import org.shopmapper.api.request.ShopRequest;
import org.shopmapper.api.response.ShopsResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;


@RequestMapping("v1/shopmapper/shop")
public interface IShopMapperController {
  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ShopsResponse> addShop(@RequestBody ShopRequest shopRequest);

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Collection<ShopsResponse>> getShops(
      @RequestParam("customerLongitude") Float customerLongitude,
      @RequestParam("customerLatitude") Float customerLatitude, @RequestParam("all") Integer all);

}
