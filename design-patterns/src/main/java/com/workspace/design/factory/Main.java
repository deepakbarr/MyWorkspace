package com.workspace.design.factory;

/**
 * Created by deepak on 11/4/14.
 */
public class Main {


    /**
     * Factory pattern - A type of creational pattern
     *
     * @param args
     */
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();

        Connection conn = connectionFactory.getConnection("pg");
        conn.connect();
        Connection conn2 = connectionFactory.getConnection("mysql");
        conn2.connect();


    }

}
