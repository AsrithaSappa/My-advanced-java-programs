package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.user;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1️⃣ Get form data
        String name = request.getParameter("name");

        // 2️⃣ Create model object
        user user = new user(name);

        // 3️⃣ Set data for JSP
        request.setAttribute("message", user.getGreeting());

        // 4️⃣ Forward to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
