package com.workspace.lens.client;

import java.io.IOException;
import java.util.HashMap;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * Created by deepak.barr on 28/07/15.
 */
public class LensClient {

  private static String lensSession = "/lensapi/session";
  private static String lensQuery = "/lensapi/queryapi/queries";
  private static String baseUrl;

  public LensClient(String hostName, int portNumber) throws IOException {
    baseUrl = constructBaseUrl(hostName, portNumber);
  }

  private String constructBaseUrl(String hostName, int portNumber) {
    return "http://" + hostName + ":" + portNumber;
  }

  public static String constructLensSessionUrl() {
    return baseUrl + lensSession;
  }

  public static String constructLensQueryUrl() {
    return baseUrl + lensQuery;
  }

  public static String constructPollLensQueryUrl(String handleId) {
    return baseUrl + lensQuery + "/" + handleId + "?";
  }

  public static String constructGetResultSetUrl(String handleId) {
    return baseUrl + lensQuery + "/" + handleId + "/" + "resultset" + "?";
  }
  public static String constructGetHTTPResultSetUrl(String handleId) {
    return baseUrl + lensQuery + "/" + handleId + "/" + "httpresultset" + "?";
  }

  public Response createLensSession(String username, String password, String sessionConf,
                                    HashMap<String, String> headers) {

//    System.out.println("[LensClient]:username = [" + username + "], password = [" + password + "]");

    RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri(constructLensSessionUrl())
      .addHeaders(headers).setContentType("multipart/form-data").addMultiPart("username", username).
        addMultiPart("password", password).
        addMultiPart("sessionconf", sessionConf)
      .build();

    return RestAssured.given().spec(requestSpec).post();
  }

  public Response makeLensQuery(String sessionId, String query, String operation, HashMap<String, String> headers) {

    RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri(constructLensQueryUrl())
      .addHeaders(headers).setContentType("multipart/form-data").addMultiPart("sessionid", sessionId)
      .addMultiPart("query", query).addMultiPart("operation", operation).build();

    return RestAssured.given().spec(requestSpec).post();
  }

  public Response pollLensQuery(String sessionId, String handleId, HashMap<String, String> headers) {

//    System.out.println("[LensClient]:sessionId = [" + sessionId + "], handleId = [" + handleId + "]");

    RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri(constructPollLensQueryUrl(handleId)
    ).addHeaders(headers).setContentType("application/json").addQueryParam("sessionid", sessionId).build();

    return RestAssured.given().spec(requestSpec).get();
  }

  public Response getLensQueryResultSet(String sessionId, String handleId, HashMap<String, String> headers) {
//    System.out.println("[LensClient]:sessionId = [" + sessionId + "], handleId = [" + handleId + "]");

    System.out.println("constructGetResultSetUrl(handleId) = " + constructGetResultSetUrl(handleId)+"sessionid="+sessionId.replaceAll("\n",""));
    RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri(constructGetResultSetUrl(handleId)
    ).addHeaders(headers).setContentType("application/json").addQueryParam("sessionid", sessionId).build();
    return RestAssured.given().spec(requestSpec).get();
  }

  public Response getLensQueryHttpResultSet(String sessionId, String handleId, HashMap<String, String> headers) {
    RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri(constructGetHTTPResultSetUrl(handleId)
    ).addHeaders(headers).setContentType("application/json").addQueryParam("sessionid", sessionId).build();
    return RestAssured.given().spec(requestSpec).get();
  }
}
