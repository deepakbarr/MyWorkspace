package com.workspace.design.Singleton;

/**
 * Created by deepak on 11/4/14.
 */
public class SampleObject {

    String name;
    public static SampleObject obj;

    private SampleObject(String hello) {
        this.name=hello;
    }

    public synchronized static SampleObject getInstance() {
        if (obj == null)
            obj = new SampleObject("Hello");
        return obj;
    }

    public String getName() {
        return name;
    }
}
