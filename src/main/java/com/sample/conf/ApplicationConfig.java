package com.sample.conf;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.sample.filter.ConditionalOneFilter;
import com.sample.filter.ConditionalTwoFilter;

@Configuration
public class ApplicationConfig extends ResourceConfig {

  public ApplicationConfig() {
    packages("com.sample.resources");
    register(ConditionalOneFilter.class);
    register(ConditionalTwoFilter.class);
  }
}
