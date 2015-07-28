package com.workspace.lens;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deepak.barr on 28/07/15.
 */
public class SessionProperties {
  public static String LENS_PERSISTENCE = "lens.query.enable.persistent.resultset";
  public static String DRIVER_PERSISTENCE = "lens.query.enable.persistent.resultset.indriver";
  public Map<String, String> properties = new HashMap();

  public void init() {
    properties.put(LENS_PERSISTENCE, "true");
//    properties.put(DRIVER_PERSISTENCE, "false");
  }

  public String getprops() {
    StringBuilder sb = new StringBuilder();

    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    sb.append("<conf>");
    sb.append("<properties>");
    for (String key : properties.keySet()) {
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
