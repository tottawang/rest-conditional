package com.sample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sample.filter.ConditionNameBindings;
import com.sample.filter.ConditionalOneFilter;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
@ConditionNameBindings.ConditionalOne
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
  public String getConditionOne(@HeaderParam(ConditionalOneFilter.HEADER) String header) {
    return header;
  }

  @GET
  @Path("condition-one-explicit")
  @ConditionNameBindings.ConditionalOne
  public String getConditionOneExplicitly(@HeaderParam(ConditionalOneFilter.HEADER) String header) {
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
  @ConditionNameBindings.ConditionalTwo
  public String getConditionTwo(@HeaderParam(ConditionalOneFilter.HEADER) String header) {
    return header;
  }
}
