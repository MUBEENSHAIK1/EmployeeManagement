<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Employee Management - Login</title>

</head>

<body>

    <h2>Employee Management System</h2>

    <h3>Login</h3>

    <%
        String error = (String) request.getAttribute("error");

        if (error != null) {
    %>

        <p style="color: red;"><%= error %></p>

    <%
        }
    %>

    <form action="${pageContext.request.contextPath}/login" method="post">

        <label>Username:</label>
        <input type="text" name="username" required>

        <br><br>

        <label>Password:</label>
        <input type="password" name="password" required>

        <br><br>

        <button type="submit">Login</button>

    </form>

</body>
</html>