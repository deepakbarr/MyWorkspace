package com.workspace.lens.test.lens;

import static com.jayway.restassured.path.xml.XmlPath.from;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.logging.Logger;

import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import com.workspace.lens.SessionProperties;
import com.workspace.lens.client.AuthNClient;
import com.workspace.lens.client.LensClient;

/**
 * Created by vidya.priyadarshini on 22/07/15.
 */
public class LensTest {

  public static LensClient lensClient;
  //  private static String HOST = "bigfoot-hydra-a-0011.nm.flipkart.com";
//  private static String HOST = "bigfoot-query-lens-0001.nm.flipkart.com";
  private static String HOST = "localhost";
//  private static String HOST = "10.33.106.138";
  private static int PORT = 9999;
//    private static String QUERY = "select B.date_dim_key, A.count from (select day, count(*) as count from bigfoot_dart.dart_wsr_scp_ekl_shipment_1_4 group by day) A right join \n" +
//      "bigfoot_external_neo.scp_oms__date_dim_fact B on A.day=B.date_dim_key limit 2";
  private static String QUERY = "select count(*) from default.test_data limit 10";
//  private static String QUERY = "select * from finished_queries limit 10";

//   private static String QUERY = "select * from bigfoot_external_neo.sp_seller__listing_count_fact limit 25";

  /**
   * Load configuration properties like HostName, PortNumber etc
   *
   * @throws IOException
   */
  public LensTest() throws IOException {
  }

  public static void main(String[] args)
    throws InterruptedException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {
    lensClient = new LensClient(HOST, PORT);

    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("FDP-Lens-App-Name", "FlipQuery");
    headers.put("FDP-Lens-Api-Key", "ce5234ac-a24b-4fe4-8679-2ebac0ec941c");
//    headers.put("FDP-Auth-Key", AuthNClient.getAuthHeader());
    headers.put("Content-Disposition", "form-data");

    Response lensSession = lensClient.createLensSession("lens", "abcd", LensUtil.getSessionConf(), headers);

    lensSession.getBody().prettyPrint();
    String sessionId = lensSession.getBody().asString();
    System.out.println("sessionid=" + sessionId);

    Response lensQuery = lensClient.makeLensQuery(sessionId, QUERY, "EXECUTE", headers);

    String xmlReponse = lensQuery.getBody().asString();

    String handleId = from(xmlReponse).get("lensResponse.data.handleId");
    System.out.println("xmlReponse = " + xmlReponse);
    System.out.println("\n\nhandleId = " + handleId);

    Response lensPollQueryResponse = lensClient.pollLensQuery(sessionId, handleId, headers);
    String queryStatus;
    lensPollQueryResponse.getBody().prettyPrint();

    do {
      Thread.sleep(5000);
      lensPollQueryResponse = lensClient.pollLensQuery(sessionId, handleId, headers);
      String xml = lensPollQueryResponse.getBody().asString();
      queryStatus = LensUtil.getQueryStatus(xml);
      System.out.println("\nQuery Status : " + queryStatus);
    } while (!(queryStatus.equalsIgnoreCase("SUCCESSFUL") || queryStatus.equalsIgnoreCase("FAILED")));
    headers.remove("Content-Disposition");

    Response lensQueryResultSet = lensClient.getLensQueryResultSet(sessionId, handleId, headers);
    System.out.println("\n\nResultset API response - ");
    lensQueryResultSet.getBody().prettyPrint();

    Response lensQueryHttpResultSet = lensClient.getLensQueryHttpResultSet(sessionId, handleId, headers);
    System.out.println("\n\nHttpResultset API response - ");
    lensQueryHttpResultSet.getBody().prettyPrint();
  }


}
