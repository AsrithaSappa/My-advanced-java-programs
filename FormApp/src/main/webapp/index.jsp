<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
            width: 350px;
            text-align: center;
        }

        h2 {
            color: #333;
            margin-bottom: 25px;
        }

        input[type="text"],
        input[type="email"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 15px;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus,
        input[type="email"]:focus {
            border-color: #4a90e2;
            outline: none;
        }

        input[type="submit"] {
            background-color: #4a90e2;
            color: white;
            border: none;
            padding: 10px 25px;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #357ABD;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Enter Your Details</h2>
        <form action="process.jsp" method="post">
            <input type="text" name="name" placeholder="Enter your name" required><br>
            <input type="email" name="email" placeholder="Enter your email" required><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>