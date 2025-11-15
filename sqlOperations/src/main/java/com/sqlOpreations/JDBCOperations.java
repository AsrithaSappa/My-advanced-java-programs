package com.sqlOpreations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCOperations {
	
	static final String URL = "jdbc:mysql://localhost:3306/student_db";
    static final String USER = "root";
    static final String PASSWORD = "root";
    
    public static void main(String[] args) {
        try {
            // 1️⃣ Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Establish Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to the database!");
            		
            String insertQuery = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = con.prepareStatement(insertQuery);
            insertStmt.setString(1, "Ashok Kumar");
            insertStmt.setString(2, "ashok@example.com");
            insertStmt.setInt(3, 21);
            int rowsInserted = insertStmt.executeUpdate();
            System.out.println(rowsInserted + " record(s) inserted.");
            

            // 6️⃣ Close the connection
            con.close();
            System.out.println("🔒 Connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }