package com.hackathon;

import lombok.Data;

/**
 * Created by deepak.barr on 05/06/15.
 */

@Data
public class Order {
    private String seller;
    private String orderId;
    private String status;
    private String lastUpdated;

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
