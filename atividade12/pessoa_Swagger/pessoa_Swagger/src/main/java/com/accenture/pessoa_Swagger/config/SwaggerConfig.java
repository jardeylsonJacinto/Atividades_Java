package com.accenture.pessoa_Swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Accenture - API")
            .description("API Accenture")
            .version("1.0")
            .termsOfService("Termo de uso: Accenture")
            .license(new io.swagger.v3.oas.models.info.License().name("Licença - Accenture Academy")
                .url("https://accenture.com/")));
  }
}
