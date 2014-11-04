package com.workspace.spring;

/**
 * Created by deepak on 10/30/14.
 */
public class Transaction {

    Retailer retailer;


//
//    public Transaction(Retailer retailer) {
//        this.retailer = retailer;
//    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }


    public String getMessage() {
        return retailer.getMessage();
    }

}
