package com.hackathon.service;

import com.hackathon.Order;
import com.hackathon.OrderManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by deepak.barr on 19/2/15.
 */

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DemoResource {

    public DemoResource(DemoServiceConfiguration conf) {
    }


    /**
     * http://localhost:8080/service/health
     *
     * @return
     */
    @GET
    @Path("health")
    public String health() {
        return "OK";
    }

    //  http://localhost:8080/service/health

    @GET
    @Path("orders")
    public Collection<Order> getOrders() {
        Collection<Order> orders = OrderManager.getOrders();
        return orders;
    }

}


