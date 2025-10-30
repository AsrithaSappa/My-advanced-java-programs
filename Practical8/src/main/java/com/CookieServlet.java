package com;


import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String user = request.getParameter("username");
        Cookie ck = new Cookie("username", user);
        response.addCookie(ck);
        
        out.println("<h2>Hello, " + user + " (stored in cookie)</h2>");
        out.println("<a href='ShowCookie'>View Cookie Data</a>");
    }
}
