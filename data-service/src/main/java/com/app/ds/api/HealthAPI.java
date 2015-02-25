package com.app.ds.api;

import com.app.ds.beans.Constants;
import com.app.ds.beans.Response;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(name = "health",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "health",
                ownerName = "health",
                packagePath = "/health"))
public class HealthAPI {

    // http://localhost:8080/_ah/api/health/v1/health
    @ApiMethod(name = "health", httpMethod = ApiMethod.HttpMethod.GET)
    public Response health() {
        Response response = new Response();
        response.put("Health", Constants.OK);
        return response;
    }
}
