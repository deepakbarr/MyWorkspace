package com.workspace.design.factory;

/**
 * Created by deepak on 11/4/14.
 */
public class MySqlConn implements Connection {

    @Override
    public void connect() {
        System.out.println("Successfully connected to MySQl");
    }
}
