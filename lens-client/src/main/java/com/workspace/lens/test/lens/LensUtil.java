package com.workspace.lens.test.lens;

import java.io.IOException;
import java.util.HashMap;

import com.jayway.restassured.path.xml.XmlPath;
import com.workspace.lens.SessionProperties;

/**
 * Created by deepak.barr on 18/12/15.
 */
public class LensUtil {

  public static final String SUCCESSFUL = "SUCCESSFUL";
  public static final String FAILED = "FAILED";

  public static HashMap getHeaders() {
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("FDP-Lens-App-Name", "FlipQuery");
    headers.put("FDP-Lens-Api-Key", "ce5234ac-a24b-4fe4-8679-2ebac0ec941c");
    headers.put("Content-Disposition", "form-data");
    return headers;
  }

  public static String getSessionConf() throws IOException {
    System.out.println("sessionProperties = " + SessionProperties.instance().getprops());
    return SessionProperties.instance().getprops();
  }

  public static String getQueryStatus(String xml) {
    XmlPath xmlPath = new XmlPath(xml).setRoot("lensQuery");
    return xmlPath.get("status.status");
  }


}
