package com.workspace.demos.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by deepak.barr on 20/11/15.
 */
public class HttpCalls {

  private final static int requests = 80;


  public static void main(String[] args) throws IOException, InterruptedException {

    System.out.println("Start 290M = " + new Date());
    while (true) {
      int i = 0;
      System.out.println("Run = " + new Date());
      while (i++ < requests) {
        post();
        System.out.println("i = " + i);
        Thread.sleep(1000);
      }
      System.exit(0);
      Thread.sleep(60000);
    }
//    while (i++ < requests)
//      get();
  }

  private static void get() {

  }

  private static void post() throws IOException {

    String url = "http://10.33.90.11:8585/metasync/sync";
    String payload = "{\n" +
      "  \"dbName\":\"bigfoot_external_neo\",\n" +
//      "  \"tables\":\"test_data\",\n" +
      "  \"syncType\":\"FULL\",\n" +
      "  \"syncPartitions\":\"true\",\n" +
      "  \"syncTables\":\"false\",\n" +
      "  \"sourceHiveUri\":\"thrift://10.32.249.171:9083\",\n" +
      "  \"targetHiveUri\":\"thrift://localhost:9083\"\n" +
      "}";

    HttpClient client = new DefaultHttpClient();
    HttpPost p = new HttpPost(url);
    p.setHeader("Content-Type", "application/json");
    p.setEntity(new StringEntity(payload));

    HttpResponse r = client.execute(p);
    BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
    String line = "";
    while ((line = rd.readLine()) != null) {
//      System.out.println(line);
    }
  }
}

/*

7.35 - 1G
7.43 - 678M


468m - 1.7G -  80 posts
442m -
 */
