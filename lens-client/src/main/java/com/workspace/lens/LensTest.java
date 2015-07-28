package com.workspace.lens;

import static com.jayway.restassured.path.xml.XmlPath.from;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import com.workspace.lens.client.LensClient;

/**
 * Created by vidya.priyadarshini on 22/07/15.
 */
public class LensTest {

  public static LensClient lensClient;
  private static String HOST = "localhost";
  private static int PORT = 9999;
  private static String QUERY = "select * from default.test_data limit 10";

  /**
   * Load configuration properties like HostName, PortNumber etc
   *
   * @throws IOException
   */
  public LensTest() throws IOException {
  }

  public static void main(String[] args) throws InterruptedException, IOException {
    lensClient = new LensClient(HOST, PORT);
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("FDP-Lens-App-Name", "FlipQuery");
    headers.put("FDP-Lens-Api-Key", "ce5234ac-a24b-4fe4-8679-2ebac0ec941c");
    headers.put("Content-Disposition", "form-data");


    Response lensSession = lensClient.createLensSession("deepak.barr", "abcd", getSessionConf(), headers);

    System.out.println("sessionHandle -");
    lensSession.getBody().prettyPrint();
    String sessionId = lensSession.getBody().asString();
    Response lensQuery = lensClient.makeLensQuery(sessionId, QUERY, "EXECUTE", headers);

    String xmlReponse = lensQuery.getBody().asString();
    String handleId = from(xmlReponse).get("lensResponse.data.handleId");
    System.out.println("\n\nhandleId = " + handleId);

    Response lensPollQueryResponse = lensClient.pollLensQuery(sessionId, handleId, headers);
    String queryStatus;
    lensPollQueryResponse.getBody().prettyPrint();

    do {
      Thread.sleep(5000);
      lensPollQueryResponse = lensClient.pollLensQuery(sessionId, handleId, headers);
      String xml = lensPollQueryResponse.getBody().asString();
      queryStatus = getQueryStatus(xml);
      System.out.println("\nQuery Status : " + queryStatus);
    } while (!queryStatus.equalsIgnoreCase("SUCCESSFUL"));
    headers.remove("Content-Disposition");

    Response lensQueryResultSet = lensClient.getLensQueryResultSet(sessionId, handleId, headers);
    System.out.println("\n\nResultset API response - ");
    lensQueryResultSet.getBody().prettyPrint();

    Response lensQueryHttpResultSet = lensClient.getLensQueryHttpResultSet(sessionId, handleId, headers);
    System.out.println("\n\nHttpResultset API response - ");
    lensQueryHttpResultSet.getBody().prettyPrint();
  }

  private static String getSessionConf() {
    SessionProperties sessionProperties = new SessionProperties();
    sessionProperties.init();
    System.out.println("sessionProperties = " + sessionProperties.getprops());
    return sessionProperties.getprops();
  }

  public static String getQueryStatus(String xml) {
    XmlPath xmlPath = new XmlPath(xml).setRoot("lensQuery");
    return xmlPath.get("status.status");
  }
}
