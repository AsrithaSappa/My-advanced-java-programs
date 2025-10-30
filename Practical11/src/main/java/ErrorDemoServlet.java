
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/errorDemo")
public class ErrorDemoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("exception".equals(action)) {
            // This will cause a server error (500)
            throw new RuntimeException("Simulated Exception");
        } else if ("notfound".equals(action)) {
            // Redirect to a non-existing page to simulate 404
            response.sendRedirect("nonExistingPage.html");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>No error triggered. Use ?action=exception or ?action=notfound</h2>");
        }
    }
}
