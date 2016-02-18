package com.workspace.demos.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by neeraj.narayan on 12/01/16.
 */
public class ApiFactory {

  protected Properties properties;
  protected TestUtils testUtils;
  private String baseUrl;
  private CloseableHttpClient httpClient;

  public ApiFactory() {
    testUtils = new TestUtils();
    httpClient = createHttpClient();

    try {
      properties = testUtils.loadProperties();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String bigfootHost = properties.getProperty("bigfoot.api.host");
    String bigfootPort = properties.getProperty("bigfoot.api.port");

    baseUrl = MessageFormat.format("http://{0}:{1}/lensapi", bigfootHost, bigfootPort);
  }

  private String getBaseUrl() {
    return baseUrl;
  }

  protected String getNewSession() throws InstantiationException {
    String sessionURL = MessageFormat.format("{0}/session", baseUrl);
    HttpPost postRequest = createPostRequest();

    try {
      postRequest.setURI(new URI(sessionURL));

      HttpEntity entity = MultipartEntityBuilder
        .create()
        .addTextBody("username", "uie_user")
        .addTextBody("password", "password")
          //.addTextBody("sessionconf", "<?xml version=\"1.0\" encoding=\"UTF-8\"?><conf></conf>", ContentType.APPLICATION_XML)
        .build();

      postRequest.setEntity(entity);
      HttpResponse response = httpClient.execute(postRequest);
      return EntityUtils.toString(response.getEntity());

    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    throw new InstantiationException("Cannot get the session");
  }

  private CloseableHttpClient createHttpClient() {
    return HttpClientBuilder.create().build();
  }

  private HttpGet createGetRequest() {
    HttpGet getRequest = new HttpGet();
    addHeaders(getRequest);
    return getRequest;
  }

  private HttpPost createPostRequest() {
    HttpPost postRequest = new HttpPost();
    addHeaders(postRequest);
    return postRequest;
  }

  private void addHeaders(HttpRequestBase requestBase) {
    requestBase.addHeader("FDP-Lens-App-Name", properties.getProperty("fdp.lens.app.name"));
    requestBase.addHeader("FDP-Lens-Api-Key", properties.getProperty("fdp.lens.api.key"));
    requestBase.addHeader("Content-Type", "multipart/form-data");
  }
}