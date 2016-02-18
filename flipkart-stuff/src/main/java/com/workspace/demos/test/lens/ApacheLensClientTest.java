package com.workspace.demos.test.lens;

import org.apache.lens.client.LensClient;
import org.apache.lens.client.exceptions.LensAPIException;

/**
 * Created by deepak.barr on 13/01/16.
 */
public class ApacheLensClientTest {

  final static String QUERY = "";
  final static String QUERY_NAME = "";

  public static void main(String[] args) throws LensAPIException {
    LensClient client = new LensClient("user", "pass");
    LensClient.LensClientResultSetWithStats results = client.getResults(QUERY, QUERY_NAME);

  }
}
