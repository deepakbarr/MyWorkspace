package com.workspace.design.factory;

/**
 * Created by deepak on 11/4/14.
 */
public class ConnectionFactory {

    public Connection getConnection(String db) {
        if (db.equals("pg"))
            return new PgSqlConn();
        if (db.equals("mysql"))
            return new MySqlConn();
        else return null;
    }
}
