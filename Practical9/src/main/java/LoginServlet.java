
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        // Simple validation (You can later connect this to a database)
        if (uname.equals("admin") && pass.equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("welcome");
        } else {
            out.println("<h3>Invalid username or password</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}
