package com.hackathon.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by deepak.barr on 19/2/15.
 */
public class DemoServiceConfiguration  extends Configuration {

    @JsonProperty
    String health;
}
