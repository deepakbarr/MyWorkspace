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
    public Output sayHello() {
        Output out=new Output();
        out.put("key",healthString);
        return out;
    }

    /**
     * http://localhost:8080/service/health
     * @return
     */
    @GET
    @Path("health")
    public Output health() {
        Output out=new Output();
        out.put("key",healthString);
        return out;
    }

    /**
     * http://localhost:8080/service/health
     * @return
     */
    @GET
    @Path("print")
    public Output printText(@QueryParam("text") String text) {
        Output out=new Output();
        out.put("text",text);
        return out;
    }
}
