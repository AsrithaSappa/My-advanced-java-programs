<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged Out</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
    }
    .logout-container {
        background: #fff;
        width: 380px;
        margin: 100px auto;
        padding: 35px 30px 25px 30px;
        border-radius: 10px;
        text-align: center;
        box-shadow: 0 6px 25px rgba(60,60,60,0.2);
    }
    h2 {
        color: #2874f0;
        margin-bottom: 16px;
    }
    a {
        display: inline-block;
        padding: 9px 28px;
        background-color: #2874f0;
        color: #fff;
        text-decoration: none;
        border-radius: 4px;
        font-size: 16px;
        margin-top: 18px;
        transition: background .3s;
    }
    a:hover {
        background-color: #1859b2;
    }
</style>
</head>
<body>
    <div class="logout-container">
        <h2>You have been logged out successfully!</h2>
        <a href="login.jsp">Login Again</a>
    </div>
</body>
</html>