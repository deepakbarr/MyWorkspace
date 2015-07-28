package com.hack.tracker;

/**
 * Created by deepak.barr on 05/06/15.
 */


public class Order {
    private String seller;
    private String orderId;
    private String status;
    private String lastUpdated;

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Order{" +
                "seller='" + seller + '\'' +
                ", orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}