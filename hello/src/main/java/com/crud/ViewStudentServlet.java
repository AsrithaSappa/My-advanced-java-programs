package com.crud;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/view")
public class ViewStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Student List</title>");
        out.println("<style>");
        out.println("body {font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #00c6ff, #0072ff); margin: 0; padding: 40px; color: #333;}");
        out.println("h2 {text-align: center; color: #fff; font-size: 28px; margin-bottom: 30px;}");
        out.println("table {border-collapse: collapse; width: 80%; margin: 0 auto; background-color: #fff; box-shadow: 0 8px 25px rgba(0,0,0,0.15); border-radius: 10px; overflow: hidden;}");
        out.println("th, td {border: 1px solid #ddd; padding: 12px 16px; text-align: center; font-size: 16px;}");
        out.println("th {background-color: #0072ff; color: white; text-transform: uppercase; letter-spacing: 0.5px;}");
        out.println("tr:nth-child(even) {background-color: #f2f2f2;}");
        out.println("tr:hover {background-color: #e6f0ff; transition: 0.3s;}");
        out.println("td {color: #333;}");
        out.println(".btn {display: block; width: 200px; margin: 30px auto; text-align: center; background: #fff; color: #0072ff; padding: 10px 0; border-radius: 8px; text-decoration: none; font-weight: bold; transition: 0.3s;}");
        out.println(".btn:hover {background: #0072ff; color: #fff; transform: scale(1.05);}");
        out.println("</style></head><body>");
        // ✅ HTML + CSS END
        
        
        out.println("<h2>Student List</h2>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>City</th></tr>");

        
        
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>"
                        + rs.getString("name") + "</td><td>"
                        + rs.getString("email") + "</td><td>"
                        + rs.getString("city") + "</td></tr>");
            }
            out.println("</table>");
            out.println("<a href='index.html' class='btn'>Back to Home</a>");
        }catch (Exception e) {
            out.println("<h3 style='color:white; text-align:center;'>Error: " + e.getMessage() + "</h3>");
        }
        
        out.println("</body></html>");
    }
}