package com.workspace.demo.vertica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

/**
 * Created by deepak.barr on 30/03/15.
 */
public class Main {

    public static void main(String[] args) {



        Connection connection;

        try {
            Class.forName("com.vertica.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:vertica://192.168.56.101:5433/demo", "dbadmin", "demo");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from demo_table");
            while (rs.next()) {
                System.out.println("rs.getString(1) = " + rs.getString(1));
                System.out.println("rs.getString(2) = " + rs.getString(2));
                System.out.println("rs.getString(3) = " + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
