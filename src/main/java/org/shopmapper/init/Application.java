package org.shopmapper.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot application
 */

@SpringBootApplication
@ComponentScan({"org.shopmapper.*", "org.shopmapper.api.*", "org.shopmapper.rest.*"})

public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

  }
}
