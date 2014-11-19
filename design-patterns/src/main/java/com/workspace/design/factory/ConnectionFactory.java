package com.workspace.design.factory;

/**
 * Created by deepak on 11/4/14.
 */
public class ConnectionFactory {


    private ConnectionFactory connectionFactory;

    private ConnectionFactory() {
    }

    public ConnectionFactory getInstance() {
        if (connectionFactory == null)
            connectionFactory = new ConnectionFactory();
        return connectionFactory;
    }

    public Connection getConnection(String db) {
        if (db.equals("pg"))
            return new PgSqlConn();
        if (db.equals("mysql"))
            return new MySqlConn();
        else return null;
    }
}
