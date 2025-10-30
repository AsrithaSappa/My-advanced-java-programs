
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/protected/dashboard")
public class ProtectedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = (String) request.getSession().getAttribute("username");
        out.println("<h2>Welcome to Dashboard, " + user + "!</h2>");
        out.println("<a href='../logout'>Logout</a>");
    }
}
