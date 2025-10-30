package com;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String name = null;

        if (session != null)
            name = (String) session.getAttribute("username");

        if (name != null) {
            out.println("<h2>Welcome back, " + name + "!</h2>");
        } else {
            out.println("<h2>No active session found. Please login again.</h2>");
        }
    }
}
