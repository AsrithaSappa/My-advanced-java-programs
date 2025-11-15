package com.transaction.controller;

import com.transaction.dao.TransactionDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int fromId = Integer.parseInt(request.getParameter("fromId"));
        int toId = Integer.parseInt(request.getParameter("toId"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        TransactionDAO dao = new TransactionDAO();
        boolean success = dao.transferMoney(fromId, toId, amount);

        if (success) {
            request.setAttribute("message", "✅ Transaction Successful!");
        } else {
            request.setAttribute("message", "❌ Transaction Failed! Rolled back.");
        }

        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
        rd.forward(request, response);
    }
}