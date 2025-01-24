package com.accenture.consumo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "feign.client.url")
public class FeignClientConfig {

  private String viacep;

  public String getViacep() {
    return viacep;
  }

  public void setViacep(String viacep) {
    this.viacep = viacep;
  }
}
