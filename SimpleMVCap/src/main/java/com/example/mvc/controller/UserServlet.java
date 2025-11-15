package com.example.mvc.controller;

import com.example.mvc.model.User;
import com.example.mvc.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = new User(name, email);
        UserDAO dao = new UserDAO();

        boolean saved = dao.saveUser(user);

        if (saved) {
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("userDetails.jsp");
            rd.forward(request, response);
        } else {
            response.getWriter().println("<h3>Error saving user data!</h3>");
        }
    }
}