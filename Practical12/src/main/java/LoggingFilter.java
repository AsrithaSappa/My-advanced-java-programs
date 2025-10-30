
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/protected/*") // Applies to all URLs under /protected
public class LoggingFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoggingFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String ip = req.getRemoteAddr();
        String uri = req.getRequestURI();
        System.out.println("Incoming request from IP: " + ip + " for URI: " + uri);

        // Example: Simple authentication check
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            res.getWriter().println("<h3>Access Denied! Please login first.</h3>");
            res.getWriter().println("<a href='../login.html'>Login</a>");
            return; // Stop further processing
        }

        // Pass the request along the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}
