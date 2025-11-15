<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Forwarding & Redirection</title>
</head>
<body>
    <h2>Request Forwarding and Redirection Demo</h2>

    <form action="ForwardServlet" method="post">
        <input type="text" name="username" placeholder="Enter username" required>
        <input type="submit" value="Login (Forward)">
    </form>

    <br>

    <a href="RedirectServlet">Go to Redirect Page</a>
</body>
</html>