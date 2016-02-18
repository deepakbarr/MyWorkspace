package com.workspace.lens.test.lens;

import static com.jayway.restassured.path.xml.XmlPath.from;

import java.io.IOException;
import java.util.Map;

import com.google.common.collect.Maps;
import com.jayway.restassured.response.Response;
import com.workspace.lens.client.LensClient;

/**
 * Created by deepak.barr on 18/12/15.
 */
public class LensTestMultipleQueries {

  public static int ITERATIONS = 20;
  public static LensClient lensClient;
//  private static String HOST = "10.33.90.11";
private static String HOST = "localhost";
  private static int PORT = 9999;
  private static String QUERY = "select count(*) from default.test_data limit 3";
  private static Map<String, String> handleSessionMap = Maps.newHashMap();
  private static Map<String, String> headers = LensUtil.getHeaders();

  public static void main(String[] args) throws IOException, InterruptedException {
    int i = 0;
    while (i++ < ITERATIONS) {
      fireQuery();
    }

    String qhandle, session, qStatus;

    while (!handleSessionMap.isEmpty()) {
      Map<String, String> mapCopy = Maps.newHashMap(handleSessionMap);
      for (Map.Entry<String, String> entry : mapCopy.entrySet()) {
        qhandle = entry.getKey();
        session = entry.getValue();
        Response lensPollQueryResponse = lensClient.pollLensQuery(session, qhandle, headers);
        String xml = lensPollQueryResponse.getBody().asString();
        qStatus = LensUtil.getQueryStatus(xml);
        if (qStatus.equals(LensUtil.SUCCESSFUL) || qStatus.equals(LensUtil.FAILED)) {
          System.out.println(String
            .format("**** Query status : %s | Query Handle :  %s | Lens Session : %s", qStatus, qhandle, session));
          handleSessionMap.remove(entry.getKey());
          if (true && qStatus.equals(LensUtil.SUCCESSFUL)) {
            printResultSet(qhandle, session);
          }
        }
      }
      mapCopy.clear();
      Thread.sleep(10000);
      System.out.println("**** Remaining queries : " + handleSessionMap.size());
    }
  }

  private static void printResultSet(String handleId, String sessionId) {
    Response lensQueryResultSet = lensClient.getLensQueryResultSet(sessionId, handleId, headers);
    System.out.println("\n\nResultset API response - ");
    lensQueryResultSet.getBody().prettyPrint();
  }

  public static void fireQuery() throws IOException {
    lensClient = new LensClient(HOST, PORT);
    Response lensSession = lensClient.createLensSession("lens", "abcd", LensUtil.getSessionConf(), headers);
    lensSession.getBody().prettyPrint();
    String sessionId = lensSession.getBody().asString();
    Response lensQuery = lensClient.makeLensQuery(sessionId, QUERY, "EXECUTE", headers);
    String xmlReponse = lensQuery.getBody().asString();
    String handleId = from(xmlReponse).get("lensResponse.data.handleId");
    System.out.println("Adding session and handle to map");
    handleSessionMap.put(handleId, sessionId);
  }
}
