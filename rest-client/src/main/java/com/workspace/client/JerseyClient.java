package com.workspace.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.map.ObjectMapper;

public class JerseyClient
{

    public static void main(String[] args) {
        try {

            Client client = Client.create();

            WebResource webResource = client
                        .resource("https://nimble-card-866.appspot.com/_ah/api/data/v1/size/quote");

            ClientResponse clientResponse = webResource.accept("application/json")
                    .get(ClientResponse.class);

            String out= clientResponse.getEntity(String.class);

            ObjectMapper mapper = new ObjectMapper();
            Response response=mapper.readValue(out, Response.class);
            for(String key:response.keySet()) {
                System.out.println("key = " + key);
                System.out.println("response.v = " + response.get(key));
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}