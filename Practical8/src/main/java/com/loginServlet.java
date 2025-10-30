package com;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("uname");

        // Create session
        HttpSession session = request.getSession();
        session.setAttribute("username", name);

        // Create cookie
        Cookie userCookie = new Cookie("user", name);
        userCookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(userCookie);

        out.println("<h3>Welcome, " + name + "!</h3>");
        out.println("<a href='welcome'>Go to Welcome Page</a>");
    }
}
