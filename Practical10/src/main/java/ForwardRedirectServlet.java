
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/process")
public class ForwardRedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String uname = request.getParameter("uname");

        if ("admin".equalsIgnoreCase(uname)) {
            // Forward request to AdminServlet
            RequestDispatcher rd = request.getRequestDispatcher("admin");
            rd.forward(request, response);
        } else {
            // Redirect to ErrorServlet
            response.sendRedirect("error");
        }
    }
}