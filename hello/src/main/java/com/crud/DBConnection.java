package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root", "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}