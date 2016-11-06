package com.sample.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
public class ConditionalFilter implements ContainerRequestFilter {

  public static final String HEADER = "X-Condition";

  @Context
  private ResourceInfo resourceInfo;

  /*
   * Set header based on different endpoint Condition annotation, this is just for testing purpose.
   */
  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    if (resourceInfo.getResourceMethod()
        .isAnnotationPresent((Class<? extends Annotation>) ConditionOne.class)) {
      requestContext.getHeaders().add(HEADER, "ConditionOne");
    } else if (resourceInfo.getResourceMethod()
        .isAnnotationPresent((Class<? extends Annotation>) ConditionTwo.class)) {
      requestContext.getHeaders().add(HEADER, "ConditionTwo");
    } else {
      requestContext.getHeaders().add(HEADER, "");
    }
  }
}
