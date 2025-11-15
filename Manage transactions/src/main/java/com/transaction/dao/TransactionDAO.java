package com.transaction.dao;

import java.sql.*;

public class TransactionDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/transactiondb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public boolean transferMoney(int fromId, int toId, double amount) {
        Connection con = null;
        PreparedStatement ps1 = null, ps2 = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            con.setAutoCommit(false); // Start transaction

            // 1️⃣ Deduct from source account
            ps1 = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            ps1.setDouble(1, amount);
            ps1.setInt(2, fromId);
            int rows1 = ps1.executeUpdate();

            // 2️⃣ Add to destination account
            ps2 = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            ps2.setDouble(1, amount);
            ps2.setInt(2, toId);
            int rows2 = ps2.executeUpdate();

            // 3️⃣ Check if both succeeded
            if (rows1 > 0 && rows2 > 0) {
                con.commit(); // Commit transaction
                return true;
            } else {
                con.rollback(); // Rollback if something went wrong
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) con.rollback(); // Rollback on error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}