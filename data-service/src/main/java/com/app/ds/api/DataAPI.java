package com.app.ds.api;

import com.app.ds.DataManager;
import com.app.ds.beans.Response;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;
import java.util.*;

/**
 * Created by deepak.barr on 24/2/15.
 */

@Api(name = "data",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "data",
                ownerName = "data",
                packagePath = "/data"))
public class DataAPI {

    // http://localhost:8080/_ah/api/data/v1/fetch/quote
    @ApiMethod(name = "fetch", httpMethod = ApiMethod.HttpMethod.GET)
    public Response fetch(@Named("type") String type) {
        String data = DataManager.INSTANCE.getRandomData(type);
        Response response = new Response();
        if (null != data)
            response.put(type, data);
        else response.put(type, "NO data for type '" + type + "' !");

        return response;
    }

    // http://localhost:8080/_ah/api/data/v1/sendQuote/quote/live%20and%20let%20live
    @ApiMethod(name = "send", httpMethod = ApiMethod.HttpMethod.GET)
    public Response sendQuote(@Named("type") String type, @Named("data") String data) {
        String status = DataManager.INSTANCE.insertData(type, data);
        Response response = new Response();
        response.put("type", type);
        response.put("status", status);
        return response;
    }

    // http://localhost:8080/_ah/api/data/v1/size/quote
    @ApiMethod(name = "size", httpMethod = ApiMethod.HttpMethod.GET)
    public Response size(@Named("type") String type) {
        long size = DataManager.INSTANCE.sizeOfData(type);
        Response response = new Response();
        response.put("type", type);
        response.put("size", new Long(size).toString());
        return response;
    }

    // http://localhost:8080/_ah/api/data/v1/fetchAll/quote
    @ApiMethod(name = "fetchAll", httpMethod = ApiMethod.HttpMethod.GET)
    public Response fetchAll(@Named("type") String type) {
        List<String> list = DataManager.INSTANCE.fetchAll(type);
        Response response = new Response();

        response.put("type", type);
        if (list != null) {
            response.put("data", list);
        } else response.put("data", "NO data for type '" + type + "' !");
        return response;
    }

    // http://localhost:8080/_ah/api/data/v1/flush/quote
    @ApiMethod(name = "flush", httpMethod = ApiMethod.HttpMethod.GET)
    public Response flush(@Named("type") String type) {
        String status = DataManager.INSTANCE.flush(type);
        Response response = new Response();
        response.put("type", type);
        response.put("status", status);
        return response;
    }

    // http://localhost:8080/_ah/api/data/v1/flushAll
    @ApiMethod(name = "flushAll", httpMethod = ApiMethod.HttpMethod.GET)
    public Response flushAll() {
        String status = DataManager.INSTANCE.flushAll();
        Response response = new Response();
        response.put("FLUSH ALL", status);
        return response;
    }

    // http://localhost:8080/_ah/api/data/v1/fetchTypes
    @ApiMethod(name = "fetchTypes", httpMethod = ApiMethod.HttpMethod.GET)
    public Response fetchTypes() {
        Set<String> dataTypes = DataManager.INSTANCE.fetchTypes();
        Response response = new Response();
        response.put("DataTypes", dataTypes);
        return response;
    }

    @ApiMethod(name = "remove", httpMethod = ApiMethod.HttpMethod.GET)
    public Response remove(@Named("type") String type, @Named("data") String data) {
        String status = DataManager.INSTANCE.remove(type, data);
        Response response = new Response();
        response.put("type", type);
        response.put("status", status);
        return response;
    }
}
