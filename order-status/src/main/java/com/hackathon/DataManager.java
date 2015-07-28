package com.hackathon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deepak.barr on 05/06/15.
 */
public class DataManager {

   private static Map<String, String> data = new HashMap<String, String>();

    public static String get(String key) {
        return data.get(key);
    }

    public static String put(String key, String value) {
        return data.put(key, value);
    }

}
