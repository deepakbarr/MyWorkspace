package com.hackathon.tunesbot;

import java.util.*;

import com.hackathon.tunesbot.beans.Constants;
import com.hackathon.tunesbot.exception.DataException;

/**
 * Created by deepak.barr on 24/2/15.
 */
public enum DataManager {
  INSTANCE;

  public static DataManager get() {
    return INSTANCE;
  }

  private Map<String, String> dataMap = new HashMap<String, String>();

  public boolean insert(String type, String data) {
    dataMap.put(type, data);
    return Constants.SUCCESS;
  }

  public String getValue(String type) {
    return dataMap.get(type);
  }

  public long getSize() {
    return dataMap.size();
  }

  public Set<String> fetchKeys() {
    return dataMap.keySet();
  }

  public boolean clear() {
    dataMap.clear();
    return Constants.SUCCESS;
  }

  public boolean remove(String key) {
    dataMap.remove(key);
    return Constants.SUCCESS;
  }
}
