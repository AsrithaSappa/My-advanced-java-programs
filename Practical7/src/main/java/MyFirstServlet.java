

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MyFirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Hello from My First Servlet!</h2>");
        out.println("<p>This servlet is running on Tomcat 10.1.</p>");
    }
}
