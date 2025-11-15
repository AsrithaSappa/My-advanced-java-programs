package com.example.filters;

import java.io.IOException;
import jakarta.servlet.*;

import jakarta.servlet.http.HttpServletRequest;



public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Incoming request: " + req.getRequestURI());
        
        // Pass request to the next filter or servlet
        chain.doFilter(request, response);

        System.out.println("Response completed for: " + req.getRequestURI());
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroyed.");
    }
}