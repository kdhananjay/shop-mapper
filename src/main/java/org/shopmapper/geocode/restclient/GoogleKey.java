package org.shopmapper.geocode.restclient;

import org.shopmapper.api.ShopMapperController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Dhananjay Kumar
 *
 */
@Component
@ConfigurationProperties("google")
public class GoogleKey {
  private static Logger logger = LoggerFactory.getLogger(ShopMapperController.class);
  String key;

  public String getKey() {
    logger.info("Google API key is :" + key);
    return key;
  }

  public void setKey(String key) {
    logger.info("Google API key from properties :" + key);
    this.key = key;
  }
}
