<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management - Employees</title>
</head>

<body>

    <h1>Employee Management System</h1>

    <h2>Employee List</h2>

    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Salary</th>
            </tr>
        </thead>

        <tbody>

            <c:forEach var="employee" items="${employees}">

                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.department}</td>
                    <td>${employee.salary}</td>
                </tr>

            </c:forEach>

        </tbody>
    </table>

</body>
</html>