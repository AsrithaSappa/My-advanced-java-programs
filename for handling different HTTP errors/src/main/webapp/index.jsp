<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home - Custom Error Pages</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef2f3;
            text-align: center;
            padding-top: 100px;
        }
        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
            margin: 10px;
            display: inline-block;
        }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <h1>Welcome to Custom Error Pages Project</h1>
    <p>Try the following links:</p>

    <a href="demo">Open Demo Servlet</a><br>
    <a href="demo?action=error">Trigger 500 Error</a><br>
    <a href="unknown.jsp">Trigger 404 Error</a>
</body>
</html>