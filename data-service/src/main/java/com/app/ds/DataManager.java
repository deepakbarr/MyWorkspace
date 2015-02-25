package com.app.ds;

import com.app.ds.beans.Constants;

import java.util.*;

/**
 * Created by deepak.barr on 24/2/15.
 */
public enum DataManager {
    INSTANCE;
    private Map<String, List<String>> dataMap = new HashMap<String, List<String>>();

    public String insertData(String type, String data) {
        try {
            List<String> list = dataMap.get(type);
            if (null == list) {
                list = new ArrayList<>();
                dataMap.put(type, list);
            }
            if (list.contains(data))
                return Constants.DATA_ALREADY_EXIST;
            list.add(data);
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.FAILED + " : " + e.getMessage();
        }
    }

    public String getRandomData(String type) {

        List<String> list = dataMap.get(type);
        if (null == list) {
            return "NO data for type " + type + " !";
        }
        ;
        int size = list.size();
        Random rand = new Random();
        int idx = rand.nextInt(size);
        return list.get(idx);
    }

    public long sizeOfData(String type) {
        return dataMap.get(type) == null ? 0 : dataMap.get(type).size();
    }

    public List<String> fetchAll(String type) {
        return dataMap.get(type);
    }

    public Set<String> fetchTypes() {
        return dataMap.keySet();
    }

    public String flushAll() {
        dataMap.clear();
        return Constants.SUCCESS;
    }

    public String flush(String type) {
        dataMap.remove(type);
        return Constants.SUCCESS;
    }

    public String remove(String type, String data) {
        List<String> list = dataMap.get(type);
        if (null != list) {
            boolean status = list.remove(data);
            if (status)
                return Constants.SUCCESS;
            return Constants.NOT_FOUND;
        }
        return Constants.NOT_FOUND;
    }
}
