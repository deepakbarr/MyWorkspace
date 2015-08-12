package com.workspace.lens;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by deepak.barr on 28/07/15.
 */
public class SessionProperties {
  public Properties properties = new Properties();

  public static SessionProperties instance() throws IOException {
    SessionProperties sessionProperties = new SessionProperties();
    sessionProperties.init();
    return sessionProperties;
  }

  public void init() throws IOException {
    properties.load(
      new FileInputStream("/Users/deepak.barr/coderep/MyWorkspace/lens-client/src/main/resources/session.properties"));
  }

  public String getprops() {
    StringBuilder sb = new StringBuilder();

    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    sb.append("<conf>");
    sb.append("<properties>");
    for (String key : properties.stringPropertyNames()) {
      sb.append("<entry>");
      sb.append("<key>");
      sb.append(key);
      sb.append("</key>");
      sb.append("<value>");
      sb.append(properties.get(key));
      sb.append("</value>");
      sb.append("</entry>");
    }
    sb.append("</properties>");
    sb.append("</conf>");

    return sb.toString();
  }
}
