package com.workspace.demos;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by deepak.barr on 17/11/15.
 */
public class DartAPITest {
  public static void main(String[] args) throws InterruptedException {

    String url = "http://10.47.2.122:28223/ingestion/";
//    String url="http://stage-pf2.stage.ch.flipkart.com:28223/ingestion/entities/fkint/bigfoot/dart";

    Client client = Client.create();
    WebResource target = client.resource(url);
    String payload =
      "{ \"demo_entity\":[ { \"entityId\":\"1\", \"data\":{ \"name\":\"deepak_%s\", \"email\":\"test_email8\", \"tel\":111111 }, \"updatedAt\":\"2013-02-08T16:02:55.123456789+05:00\", \"schemaVersion\":\"1.0\" }, { \"entityId\":\"2\", \"data\":{ \"name\":\"df\", \"email\":\"test_email9\", \"tel\":111111 }," +
        " \"updatedAt\":\"2013-02-08T16:02:56.123456789+05:00\", \"schemaVersion\":\"1.0\" } ] }";


    int i = 1;
    while (true) {
      ClientResponse response = target.type("application/json")
        .post(ClientResponse.class, String.format(payload, i++));
      System.out.println("Output from Server .... \n");
      String output = response.getEntity(String.class);
      System.out.println(output);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
          + response.getStatus());
      }
      Thread.sleep(5000);
    }
  }
}