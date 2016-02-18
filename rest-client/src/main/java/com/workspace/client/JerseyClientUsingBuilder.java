package com.workspace.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Created by deepak.barr on 14/01/16.
 */
public class JerseyClientUsingBuilder {

  static final String URL="http://localhost:8080/service";

  public static void main(String[] args) {
    Client client = ClientBuilder.newClient().register(JacksonFeature.class);
    WebTarget target=client.target(URL);
    target=target.path("/health");
    String  out=target.request().get(String .class);
    System.out.println("out = " + out);
  }
}
