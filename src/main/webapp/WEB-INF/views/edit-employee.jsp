<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Edit Employee - Employee Management</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="container">

    <!-- Header -->

    <div class="header">

        <h1>Employee Management System</h1>

        <p>Update employee information</p>

    </div>


    <!-- Navigation -->

    <div class="navbar">

        <div>

            <a href="${pageContext.request.contextPath}/home">
                Home
            </a>

            <a href="${pageContext.request.contextPath}/employees">
                Employees
            </a>

        </div>

        <div>

            <a href="${pageContext.request.contextPath}/logout">
                Logout
            </a>

        </div>

    </div>


    <!-- Edit Employee Form -->

    <div class="card">

        <h2>Edit Employee</h2>

        <p>
            Update the employee details below.
        </p>

        <form action="${pageContext.request.contextPath}/employees"
              method="post">

            <input type="hidden"
                   name="action"
                   value="update">

            <input type="hidden"
                   name="id"
                   value="${employee.id}">


            <!-- Name -->

            <div class="form-group">

                <label for="name">
                    Name
                </label>

                <input type="text"
                       id="name"
                       name="name"
                       value="${employee.name}"
                       required>

            </div>


            <!-- Email -->

            <div class="form-group">

                <label for="email">
                    Email
                </label>

                <input type="email"
                       id="email"
                       name="email"
                       value="${employee.email}"
                       required>

            </div>


            <!-- Department -->

            <div class="form-group">

                <label for="department">
                    Department
                </label>

                <input type="text"
                       id="department"
                       name="department"
                       value="${employee.department}"
                       required>

            </div>


            <!-- Salary -->

            <div class="form-group">

                <label for="salary">
                    Salary
                </label>

                <input type="number"
                       id="salary"
                       name="salary"
                       value="${employee.salary}"
                       step="0.01"
                       min="0"
                       required>

            </div>


            <!-- Buttons -->

            <button type="submit"
                    class="btn btn-primary">

                Update Employee

            </button>

            <a href="${pageContext.request.contextPath}/employees"
               class="btn btn-secondary">

                Cancel

            </a>

        </form>

    </div>


    <!-- Navigation -->

    <div style="margin-top: 20px;">

        <a href="${pageContext.request.contextPath}/home"
           class="btn btn-secondary">

            ← Back to Home

        </a>

    </div>


    <!-- Footer -->

    <div class="footer">

        Employee Management System

    </div>

</div>

</body>

</html>