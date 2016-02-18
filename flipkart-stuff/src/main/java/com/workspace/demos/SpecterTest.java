package com.workspace.demos;

import static com.flipkart.specter.SpecterClient.sendToSpecter;

import java.io.IOException;

import com.flipkart.phantom.client.exceptions.PhantomClientException;
import com.flipkart.phantom.client.sockets.PhantomClientSocket;
import com.flipkart.phantom.client.sockets.PhantomSocketFactory;
import com.flipkart.specter.SpecterRequest;
import com.flipkart.specter.ingestion.IngestionMetadata;
import com.flipkart.specter.ingestion.events.Event;
import fkint.bigfoot.dg.cosmos_audit_event;

/**
 * Created by deepak.barr on 28/12/15.
 */
public class SpecterTest {
  static final String socketFilePath = "/var/run/flipkart/specter/socket/specter.sock";

  public static void main(String[] args) throws PhantomClientException, IOException {
    System.out.println("Starting to send to specter  !");
    PhantomClientSocket socket = PhantomSocketFactory.getInstance(socketFilePath);
    String testEventId = "f7917a55-3580-4304-849c-ee8ea55431f0";
    String testEventTime = "2015-05-10T18:12:13+05:30";

//SampleEvent can be found in specter client library under test code. The FQDN of the Event becomes the ingestionURI
    Event event = new Event(testEventId, testEventTime, new cosmos_audit_event());
    IngestionMetadata ingestionMetadata = new IngestionMetadata();
    ingestionMetadata.setRequestId("requestId");
    SpecterRequest request = new SpecterRequest(event, ingestionMetadata);
    sendToSpecter(socket, request);
    System.out.println("Sent to specter !");

  }
}
