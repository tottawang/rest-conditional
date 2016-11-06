package com.sample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sample.filter.ConditionOne;
import com.sample.filter.ConditionTwo;
import com.sample.filter.ConditionalFilter;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
public class RestResource {

  /**
   * getConditionOne endpoint having ConditionOne annotation returns string 'ConditionOne',
   * implemented by ConditionalFilter.
   * 
   * @param header
   * @return
   */
  @GET
  @Path("condition-one")
  @ConditionOne()
  public String getConditionOne(@HeaderParam(ConditionalFilter.HEADER) String header) {
    return header;
  }

  /**
   * getConditionTwo endpoint having ConditionTwo annotation returns string 'ConditionTwo',
   * implemented by ConditionalFilter
   * 
   * @param header
   * @return
   */
  @GET
  @Path("condition-two")
  @ConditionTwo()
  public String getConditionTwo(@HeaderParam(ConditionalFilter.HEADER) String header) {
    return header;
  }

  /**
   * getConditionNon endpoint without Condition annotation returns empty, implemented by
   * ConditionalFilter
   * 
   * @param header
   * @return
   */
  @GET
  @Path("condition-non")
  public String getConditionNon(@HeaderParam(ConditionalFilter.HEADER) String header) {
    return header;
  }
}
