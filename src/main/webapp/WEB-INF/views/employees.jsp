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

    <!-- Add Employee -->

    <h2>Add Employee</h2>

    <form action="${pageContext.request.contextPath}/employees"
          method="post">

        <label>Name:</label>

        <input type="text"
               name="name"
               required>

        <br><br>

        <label>Email:</label>

        <input type="email"
               name="email"
               required>

        <br><br>

        <label>Department:</label>

        <input type="text"
               name="department"
               required>

        <br><br>

        <label>Salary:</label>

        <input type="number"
               name="salary"
               step="0.01"
               required>

        <br><br>

        <button type="submit">Add Employee</button>

    </form>

    <hr>

    <!-- Employee List -->

    <h2>Employee List</h2>

    <table border="1" cellpadding="10">

        <thead>

            <tr>

                <th>ID</th>

                <th>Name</th>

                <th>Email</th>

                <th>Department</th>

                <th>Salary</th>

                <th>Action</th>

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

                    <td>

                        <a href="${pageContext.request.contextPath}/employees?action=edit&id=${employee.id}">
                            Edit
                        </a>

                    </td>

                </tr>

            </c:forEach>

        </tbody>

    </table>

</body>

</html>