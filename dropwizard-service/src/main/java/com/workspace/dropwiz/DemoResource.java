package com.workspace.dropwiz;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by deepak.barr on 19/2/15.
 */

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DemoResource {

    private String healthString;
    private String helloString;

    public DemoResource(DemoServiceConfiguration conf) {
        this.healthString = conf.getMessage().getHealth();
        this.helloString = conf.getMessage().getHello();
    }

    /**
     * http://localhost:8080/service/hello
     * @return
     */
    @GET
    @Path("hello")
    public String sayHello() {
        return helloString;
    }

    /**
     * http://localhost:8080/service/health
     * @return
     */
    @GET
    @Path("health")
    public String health() {
        return healthString;
    }

    /**
     * http://localhost:8080/service/health
     * @return
     */
    @GET
    @Path("print")
    public String printText(@QueryParam("text") String text) {
        return text;
    }
}
