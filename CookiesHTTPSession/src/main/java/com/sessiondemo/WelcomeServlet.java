package com.sessiondemo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;



@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (username == null) {
            response.getWriter().println("<h3>Session expired. Please <a href='login.jsp'>login again</a>.</h3>");
            return;
        }

        // Read from cookies
        Cookie[] cookies = request.getCookies();
        String cookieUser = "Unknown";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    cookieUser = c.getValue();
                }
            }
        }

        response.getWriter().println(
        	    "<div style='font-family: Arial, sans-serif; max-width: 400px; margin: 50px auto; padding: 20px; background-color: #f4f4f4; border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.1);'>"
        	    + "<h2 style='color: #2874f0; margin-bottom: 16px;'>Welcome, " + username + "!</h2>"
        	    + "<p style='font-size: 16px; color: #555;'>Cookie User: " + cookieUser + "</p>"
        	    + "<a href='LogoutServlet' style='display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #2874f0; color: #fff; text-decoration: none; border-radius: 4px; transition: background 0.3s;'>Logout</a>"
        	    + "</div>"
        	);

    }
}