package com.hackathon;

import java.util.Random;

/**
 * Created by deepak.barr on 05/06/15.
 */
public class Crawler {

    private static String findRetailer(String line) {
        if (line.toLowerCase().contains(Constants.AMAZON.toLowerCase()))
            return Constants.AMAZON;
        else if (line.toLowerCase().contains(Constants.FLIPKART.toLowerCase()))
            return Constants.FLIPKART;
        else return null;
    }

    /*

        SUBJECT:Fwd: Your Amazon.in order (#402-8326541-4173163) of "Sennheiser CX 180 Street II..." has been dispatched!
                SUBJECT:Fwd: Your Amazon.in order #402-8326541-4173163 has been delivered
        SUBJECT:Fwd: Order Confirmation - Your Order with Flipkart.com [OD202578565996912600] has bee
     */

    private static String findOrderId(String retailer, String line) {

        if (retailer.equals(Constants.FLIPKART)) {
            line = line.replaceAll("[\\[\\]]", "");
            String[] tokens = line.split(" ");
            for (String token : tokens)
                if (token.startsWith("OD"))
                    return token;
        } else if (retailer.equals(Constants.AMAZON)) {
            line = line.replaceAll("[()]", "");
            String[] tokens = line.split(" ");
            for (String token : tokens)
                if (token.startsWith("#"))
                    return token.substring(1);
        }
        return null;
    }

    public static Order fetchOrder(String line) {
        String retailer = findRetailer(line);

        if (null == retailer)
            return null;
        String orderId = findOrderId(retailer, line);
        if (null == orderId)
            return null;
        String status = findStatus(retailer, line);
        if (null == status)
            return null;

        Order order = new Order();
        order.setSeller(retailer);
        order.setStatus(status);
        order.setOrderId(orderId);
        return order;
    }

    private static String findStatus(String retailer, String line) {

        if (retailer.equals(Constants.AMAZON)) {
            if (line.toLowerCase().contains("dispatched"))
                return Constants.DISPATCHED;
            if (line.contains("delivered"))
                return Constants.DELIVERED;
        } else if (retailer.equals(Constants.FLIPKART)) {
            if (line.toLowerCase().contains("confirmation"))
                return Constants.CONFIRMED;
            if (line.toLowerCase().equals("shipped"))
                return Constants.SHIPPED;
        }
        return null;
    }
}
