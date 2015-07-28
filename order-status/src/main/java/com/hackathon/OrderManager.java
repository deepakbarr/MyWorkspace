package com.hackathon;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * Created by deepak.barr on 05/06/15.
 */
public class OrderManager {
    @JsonProperty
    private static Map<String, Order> orders = new HashMap<String, Order>();

    public static Collection<Order> getOrders() {
        return orders.values();
    }

    public static void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public static void removeOrder(String orderId) {
        orders.remove(orderId);
    }


    public static void printOrders() {

        if(orders.size()==0)
            System.out.printf("No orders");
        else {

            for(Order order:orders.values())
                System.out.println("order = " + order);

        }

    }
}
