package com.workspace.dropwiz;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deepak.barr on 19/2/15.
 */
public class Output {

    @JsonProperty("output")
    private Map<String, String> keyValues = new HashMap<String, String>();


    public void put(String k, String v) {
        keyValues.put(k, v);
    }

    public String get(String k) {
        return keyValues.get(k);
    }

}
