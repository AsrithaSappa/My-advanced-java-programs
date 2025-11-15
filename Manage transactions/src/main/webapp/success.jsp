<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transaction Result</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            text-align: center;
            padding-top: 100px;
            background: #f7fafc;
        }
        h2 {
            color: #333;
        }
        .msg {
            font-size: 20px;
            color: #007bff;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>Transaction Status</h2>
    <div class="msg">${message}</div>
    <a href="transfer.jsp">Go Back</a>
</body>
</html>