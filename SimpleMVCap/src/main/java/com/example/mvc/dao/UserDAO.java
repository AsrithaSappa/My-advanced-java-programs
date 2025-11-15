package com.example.mvc.dao;

import com.example.mvc.model.User;
import java.sql.*;

public class UserDAO {

    // JDBC connection details
    private static final String URL = "jdbc:mysql://localhost:3306/simplemvcdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // 🔁 Change this

    // 1️⃣ Load JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 2️⃣ Save user data
    public boolean saveUser(User user) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}