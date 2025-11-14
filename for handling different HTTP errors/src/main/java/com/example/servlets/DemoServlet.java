package com.example.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("error".equalsIgnoreCase(action)) {
            // Trigger a 500 error (for testing)
            int result = 10 / 0;
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h2>Welcome to Demo Servlet!</h2>");
            response.getWriter().println("<p>Use ?action=error to trigger an internal error.</p>");
        }
    }
}