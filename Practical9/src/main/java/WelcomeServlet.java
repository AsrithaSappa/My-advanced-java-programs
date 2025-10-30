
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            out.println("<h2>Welcome, " + user + "!</h2>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<h3>No active session. Please <a href='login.html'>login</a> again.</h3>");
        }
    }
}
