package com.app.ds.api;

import com.app.ds.beans.MyBean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/

@Api(name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "demo",
                ownerName = "demo",
                packagePath="/api"))
public class YourFirstAPI {
    // http://localhost:8080/_ah/api/myApi/v1/sayHi
    @ApiMethod(name = "hw", httpMethod = ApiMethod.HttpMethod.GET)
        public MyBean sayHi() {
        return new MyBean("Hello, this is api");
    }
    @ApiMethod(name = "hello", httpMethod = ApiMethod.HttpMethod.GET)
    public MyBean sayName(@Named("name") String name) {
        return new MyBean("Hello, this is "+name+".");
    }
}
