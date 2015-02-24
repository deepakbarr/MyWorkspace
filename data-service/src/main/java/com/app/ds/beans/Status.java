package com.app.ds.beans;

/**
 * Created by deepak.barr on 24/2/15.
 */
public class Status {
    private String status;
    public Status(String status) {
        this.status = status;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
}
