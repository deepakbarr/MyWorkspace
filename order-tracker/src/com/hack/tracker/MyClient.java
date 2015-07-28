package com.hack.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak.barr on 05/06/15.
 */
public class MyClient {

    public List<Order> getOrderStatuses() {

//        Client client = Client.create();
//        WebResource webResource = client.resource("http://172.20.201.232:8080/service/orders");
//
//        ClientResponse clientResponse = webResource.accept("application/json")
//                .get(ClientResponse.class);
//        System.out.println("clientResponse = " + clientResponse);
//        String jsonResponse = clientResponse.getEntity(String.class);
//
//        System.out.println("jsonResponse = " + jsonResponse);
        List<Order> orderList = getDummyOrders();
        return orderList;
    }

    /*
    {
seller: "AMAZON",
orderId: "402-8326541-4173163",
status: "DELIVERED",
lastUpdated: "2015-06-05 18:17"
},
     */
//
//    public List<Order> parseOrders(String response) throws ParseException {
//        JSONParser parser = new JSONParser();
//        Object obj = parser.parse(response);
//
//        List<Order> orderList = new ArrayList<Order>();
//
//        JSONArray jsonArray = (JSONArray) obj;
//        Iterator<JSONObject> iterator = jsonArray.iterator();
//        while (iterator.hasNext()) {
//            JSONObject orderJson = (JSONObject) iterator.next();
//            Order order = new Order();
//            order.setSeller((String) orderJson.get("seller"));
//            order.setStatus((String) orderJson.get("status"));
//            order.setOrderId((String) orderJson.get("orderId"));
//            order.setLastUpdated((String) orderJson.get("lastUpdated"));
//            orderList.add(order);
//            System.out.println("order = " + order);
//        }
//        return orderList;
//    }

    /*
    [
    {
    seller: "AMAZON",
    orderId: "OD202578565996912600",
    status: "DELIVERED",
    lastUpdated: "2015-06-05 18:17"
    },
    {
    seller: "FLIPKART",
    orderId: "OD202578565996912600",
    status: "CONFIRMED",
    lastUpdated: "2015-06-05 18:17"
    }
    ]
     */
    public List<Order> getDummyOrders() {

        List<Order> orderList = new ArrayList<>(2);

        Order order = new Order();
        order.setSeller("AMAZON");
        order.setStatus("DELIVERED");
        order.setOrderId("402-8326541-4173163");
        order.setLastUpdated("2015-06-05 18:17");
        orderList.add(order);
        order = new Order();
        order.setSeller("FLIPKART");
        order.setStatus("CONFIRMED");
        order.setOrderId("OD202578565996912600");
        order.setLastUpdated("2015-06-05 18:17");
        orderList.add(order);
        order = new Order();
        order.setSeller("SNAPDEAL");
        order.setStatus("CONFIRMED");
        order.setOrderId("5536698215");
        order.setLastUpdated("2015-06-05 18:17");
        orderList.add(order);
        return orderList;
    }
}