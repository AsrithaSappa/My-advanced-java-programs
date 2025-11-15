<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.mvc.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head><title>User Details</title></head>
<body>
<h2>User Information</h2>
<p><strong>Name:</strong> <%= user.getName() %></p>
<p><strong>Email:</strong> <%= user.getEmail() %></p>
<a href="index.jsp">Go Back</a>
</body>
</html>