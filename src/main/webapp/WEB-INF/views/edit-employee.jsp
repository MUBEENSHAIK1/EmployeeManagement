<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>

<body>

    <h1>Employee Management System</h1>

    <h2>Edit Employee</h2>

    <form action="${pageContext.request.contextPath}/employees"
          method="post">

        <input type="hidden"
               name="action"
               value="update">

        <input type="hidden"
               name="id"
               value="${employee.id}">

        <label>Name:</label>
        <input type="text"
               name="name"
               value="${employee.name}"
               required>
        <br><br>

        <label>Email:</label>
        <input type="email"
               name="email"
               value="${employee.email}"
               required>
        <br><br>

        <label>Department:</label>
        <input type="text"
               name="department"
               value="${employee.department}"
               required>
        <br><br>

        <label>Salary:</label>
        <input type="number"
               name="salary"
               value="${employee.salary}"
               step="0.01"
               required>
        <br><br>

        <button type="submit">Update Employee</button>

    </form>

    <br>

    <a href="${pageContext.request.contextPath}/employees">
        Back to Employee List
    </a>

</body>

</html>