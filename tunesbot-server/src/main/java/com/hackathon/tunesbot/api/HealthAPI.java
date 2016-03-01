package com.hackathon.tunesbot.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.hackathon.tunesbot.beans.Constants;
import com.hackathon.tunesbot.beans.Response;

@Api(name = "health",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "health",
                ownerName = "health",
                packagePath = "/health"))
public class HealthAPI {
    @ApiMethod(name = "health", httpMethod = ApiMethod.HttpMethod.GET)
    public Response health() {
        Response response = new Response();
        response.put("Health", Constants.OK);
        return response;
    }
}

