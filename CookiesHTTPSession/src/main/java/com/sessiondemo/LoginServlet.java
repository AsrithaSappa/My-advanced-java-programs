package com.sessiondemo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple login validation
        if ("admin".equals(username) && "123".equals(password)) {

            // --- Create Cookie ---
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 5); // 5 minutes
            response.addCookie(cookie);

            // --- Create HttpSession ---
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(300); // 5 minutes

            response.sendRedirect("WelcomeServlet");
        } else {
            response.getWriter().println("<h3>Invalid credentials. Try again.</h3>");
        }
    }
}
