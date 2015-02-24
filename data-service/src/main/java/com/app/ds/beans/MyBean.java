package com.app.ds.beans;

/**
 * Created by deepak.barr on 24/2/15.
 */
public class MyBean {

    private String myData;


    public MyBean(String myData) {
        this.myData = myData;
    }

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}