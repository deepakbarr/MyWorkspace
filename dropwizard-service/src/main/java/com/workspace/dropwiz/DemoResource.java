package com.workspace.dropwiz;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by deepak.barr on 19/2/15.
 */
@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {

    @GET
    @Path("hello")
    public String sayHello() {
        return "HELLO WORLD !";
    }

    @GET
    @Path("health")
    public String health() {
        return "Service is up !!";
    }
}
