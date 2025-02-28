package com.practice.sample;

/**
package com.practice.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * All rights reserved.
 *
 */
/**
@Configuration
public class OpenApiConfig implements WebMvcConfigurer {

  @Bean
  public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
    @Value("${application-version}") String appVersion) {
    return new OpenAPI()
      .info(apiInfo(appDesciption, appVersion));
  }

  private Info apiInfo(String appDesciption, String appVersion) {
    return new Info()
      .title("Book Library Impl")
      .version(appVersion)
      .description(appDesciption)
      .termsOfService("http://localhost:8080")
      .contact(new Contact().email("test@gmail.com").name("test").url(
        "https://github.com/Rohitash04/SpringRestExample"));
  }

}
**/
