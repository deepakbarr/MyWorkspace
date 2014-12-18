package com.workspace.demo.fraud;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by deepak on 12/11/14.
 */
public class PopulateMetadata {

    public static void main(String[] args) {

        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://stgdb-01.m10n.uj2.inmobi.com:5499/wap_prod",
                    "tester", "tester123");

            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("select * from wap_site limit 1");

            List<String> sites=new LinkedList<String>();

            while (rs.next()) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
