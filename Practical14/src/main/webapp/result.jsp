<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.user" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user" class="com.user" scope="request" />
<jsp:setProperty name="user" property="*" />

<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h2>User Details</h2>
    <p>Name: <%= user.getName() %></p>
    <p>Age: <%= user.getAge() %></p>

    <%
        if(user.getAge() >= 18){
    %>
        <p>Status: You are eligible.</p>
    <%
        } else {
    %>
        <p>Status: You are not eligible.</p>
    <%
        }
    %>

    <a href="form.jsp">Go Back</a>
</body>
</html>
