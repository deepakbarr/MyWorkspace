package com.workspace.design.Singleton;

/**
 * Created by deepak on 11/21/14.
 */
public enum SingletonEnum {

    INSTANCE;
    private static String name="deepakdd";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
