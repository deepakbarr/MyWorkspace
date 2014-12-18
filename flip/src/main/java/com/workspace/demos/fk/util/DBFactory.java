package com.workspace.demos.fk.util;

/**
 * Created by deepak on 12/16/14.
 */
public class DBFactory {

    private static DBFactory dbFactory = new DBFactory();

    private DBFactory() {
    }

    public static DBFactory getInstance() {
        return dbFactory;
    }

    public MockDB getDB(String db) {
        if (db.equals(Constants.MOCKDB))
            return MockDB.INSTANCE;
        else return null;
    }
}
