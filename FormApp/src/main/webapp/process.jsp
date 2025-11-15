<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.UserBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Result</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background: linear-gradient(135deg, #ACB6E5, #74ebd5);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .result-container {
            background-color: #fff;
            padding: 40px 50px;
            border-radius: 15px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
            width: 380px;
            text-align: center;
        }

        h2 {
            color: #333;
            margin-bottom: 25px;
        }

        p {
            font-size: 18px;
            color: #555;
            margin: 10px 0;
        }

        b {
            color: #4a90e2;
        }

        .btn {
            display: inline-block;
            margin-top: 25px;
            padding: 10px 25px;
            background-color: #4a90e2;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #357ABD;
        }
    </style>
</head>
<body>
    <div class="result-container">
        <jsp:useBean id="user" class="com.example.UserBean" scope="request" />
        <jsp:setProperty name="user" property="*" />

        <h2>Submitted Details</h2>
        <p><b>Name:</b> <jsp:getProperty name="user" property="name" /></p>
        <p><b>Email:</b> <jsp:getProperty name="user" property="email" /></p>

        <a href="index.jsp" class="btn">Go Back</a>
    </div>
</body>
</html>