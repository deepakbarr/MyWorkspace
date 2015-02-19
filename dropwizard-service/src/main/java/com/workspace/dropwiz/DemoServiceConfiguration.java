package com.workspace.dropwiz;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by deepak.barr on 19/2/15.
 */
public class DemoServiceConfiguration  extends Configuration {

    @JsonProperty
    Messages messages;

    public Messages getMessage() {
        return messages;
    }

    public void setMessage(Messages message) {
        this.messages = message;
    }
}
