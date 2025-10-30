<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Basic JSP Page</title>
</head>
<body>
    <h2>Welcome to JSP Page!</h2>

    <% 
        // Scriptlet: Java code inside JSP
        String name = "Asritha";
        int age = 22;
    %>

    <p>Hello, <%= name %>! Your age is <%= age %>.</p>

    <%-- If-Else in JSP --%>
    <%
        if(age >= 18){
    %>
        <p>You are eligible.</p>
    <%
        } else {
    %>
        <p>You are not eligible.</p>
    <%
        }
    %>
</body>
</html>
