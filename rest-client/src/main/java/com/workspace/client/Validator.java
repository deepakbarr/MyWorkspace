package com.workspace.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

/**
 * Created by deepak.barr on 23/05/15.
 */
public class Validator {

    public static void main(String[] args) {

        try {
            final String logFile = "/var/log/validation.log";

            File file = new File(logFile);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            long[] inputs = new long[]{100, 200, 300, 400, 1000, 1500};

            Client client = Client.create();

            String URL = "http://localhost:8080/service/test?sleep=";
            for (long input : inputs) {
                long start = Calendar.getInstance().getTimeInMillis();
                System.out.println(start);
                WebResource webResource = client
                        .resource(URL + input);
                ClientResponse clientResponse = webResource.accept("application/json")
                        .get(ClientResponse.class);
                long finish = Calendar.getInstance().getTimeInMillis();
                System.out.println(finish);
                bw.write("Input : " + input + " | recorded  :" + (finish - start)+"\n");
            }

            bw.flush();
            bw.close();
        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
