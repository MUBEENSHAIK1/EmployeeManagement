<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management - Home</title>
</head>

<body>

    <h1>Employee Management System</h1>

    <h2>Welcome, ${sessionScope.username}!</h2>

    <p>You have successfully logged in.</p>

    <hr>

    <h3>Employee Management</h3>

    <ul>
        <li>View Employees</li>
        <li>Add Employee</li>
        <li>Update Employee</li>
        <li>Delete Employee</li>
    </ul>

</body>
</html>