package com.sample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sample.filter.ConditionNameBindings;
import com.sample.filter.ConditionalOneFilter;
import com.sample.filter.ConditionalTwoFilter;

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
  public String getConditionOne(@HeaderParam(ConditionalOneFilter.HEADER) String header,
      @HeaderParam(ConditionalTwoFilter.HEADER) String header1) {
    return "[Conditional One Header]: " + header + " [Conditional Two Header]: " + header1;
  }

  @GET
  @Path("condition-one-explicit")
  @ConditionNameBindings.ConditionalOne
  public String getConditionOneExplicitly(@HeaderParam(ConditionalOneFilter.HEADER) String header,
      @HeaderParam(ConditionalTwoFilter.HEADER) String header1) {
    return "[Conditional One Header]: " + header + " [Conditional Two Header]: " + header1;
  }

  /**
   * getConditionTwo endpoint having ConditionTwo annotation returns string 'ConditionTwo',
   * implemented by ConditionalFilter
   * 
   * Note that ConditionalOne name binding has already been setup in resource level, hence this
   * resource method will trigger both ConditionOneFilter and ConditionalTwoFilter.
   * 
   * @param header
   * @return
   */
  @GET
  @Path("condition-two")
  @ConditionNameBindings.ConditionalTwo
  public String getConditionTwo(@HeaderParam(ConditionalOneFilter.HEADER) String header,
      @HeaderParam(ConditionalTwoFilter.HEADER) String header1) {
    return "[Conditional One Header]: " + header + " [Conditional Two Header]: " + header1;
  }

  @GET
  @Path("condition-one-and-two")
  @ConditionNameBindings.ConditionalOne
  @ConditionNameBindings.ConditionalTwo
  public String getConditionOneAndTwo(@HeaderParam(ConditionalOneFilter.HEADER) String header,
      @HeaderParam(ConditionalTwoFilter.HEADER) String header1) {
    return "[Conditional One Header]: " + header + " [Conditional Two Header]: " + header1;
  }
}
