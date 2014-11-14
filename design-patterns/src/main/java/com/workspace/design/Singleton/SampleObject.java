package com.workspace.design.Singleton;

/**
 * Created by deepak on 11/4/14.
 */
public class SampleObject {

    public static SampleObject obj;

    private SampleObject() {
    }

    public synchronized static SampleObject getInstance() {
        if (obj == null)
            obj = new SampleObject();
        return obj;
    }
}
