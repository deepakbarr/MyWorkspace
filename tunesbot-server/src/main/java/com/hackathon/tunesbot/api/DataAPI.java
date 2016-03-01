package com.hackathon.tunesbot.api;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.hackathon.tunesbot.DataManager;
import com.hackathon.tunesbot.beans.Response;

/**
 * Created by deepak.barr on 24/2/15.
 */

@Api(name = "data",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "data",
                ownerName = "data",
                packagePath = "/data"))
public class DataAPI {


    // http://localhost:8082/_ah/api/data/v1/getAll
    @ApiMethod(name = "fetchAll", httpMethod = ApiMethod.HttpMethod.GET)
    public Response fetchAll() {
        Set<String> list = DataManager.get().fetchKeys();
        Response response = new Response();
        if (list != null) {
            response.put("Data", list);
        } else
        response.put("Data", "No data found");
        return response;
    }


    // http://localhost:8082/_ah/api/data/v1/get/$key
    @ApiMethod(name = "fetch", httpMethod = ApiMethod.HttpMethod.GET)
    public Response fetch(@Named("key") String key) {
        String data = DataManager.get().getValue(key);
        Response response = new Response();
        if (null != data)
            response.put(key, data);
        else response.put(key, "No data for key '" + key + "' !");
        return response;
    }

    // http://localhost:8082/_ah/api/data/v1/publish/$top_billboard/$some_data
    @ApiMethod(name = "publish", httpMethod = ApiMethod.HttpMethod.GET)
    public Response publish(@Named("key") String key, @Named("value") String value) {
        boolean status = DataManager.get().insert(key, value);
        Response response = new Response();
        response.put("Key", key);
        response.put("Status", status);
        return response;
    }

    // http://localhost:8082/_ah/api/data/v1/size
    @ApiMethod(name = "size", httpMethod = ApiMethod.HttpMethod.GET)
    public Response size() {
        long size = DataManager.get().getSize();
        Response response = new Response();
        response.put("Size", size);
        return response;
    }


    // http://localhost:8082/_ah/api/data/v1/remove/$key
    @ApiMethod(name = "remove", httpMethod = ApiMethod.HttpMethod.GET)
    public Response remove(@Named("key") String key) {
        boolean status = DataManager.get().remove(key);
        Response response = new Response();
        response.put("Key", key);
        response.put("Status", status);
        return response;
    }

    // http://localhost:8082/_ah/api/data/v1/flush
    @ApiMethod(name = "flush", httpMethod = ApiMethod.HttpMethod.GET)
    public Response flush() {
        boolean status = DataManager.get().clear();
        Response response = new Response();
        response.put("Status", status);
        return response;
    }
}
