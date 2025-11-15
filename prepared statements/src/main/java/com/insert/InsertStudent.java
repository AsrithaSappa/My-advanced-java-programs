package com.insert;

import java.sql.*;

public class InsertStudent {
	 public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/prepared_statement";
	        String user = "root";
	        String password = "root";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, user, password);

	            String query = "INSERT INTO student (name, email, course) VALUES (?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setString(1, "Ashok");
	            ps.setString(2, "ashok@example.com");
	            ps.setString(3, "CSE");

	            int rows = ps.executeUpdate();
	            System.out.println(rows + " record inserted successfully!");

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}