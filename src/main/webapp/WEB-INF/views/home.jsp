<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Employee Management - Dashboard</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="container">

        <!-- Header -->

        <div class="header">

            <h1>Employee Management System</h1>

            <p>
                Welcome back, ${sessionScope.username}!
            </p>

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


        <!-- Welcome -->

        <div class="card">

            <h2>
                Welcome, ${sessionScope.username}!
            </h2>

            <p>
                You have successfully logged in.
            </p>

            <p>
                Manage employee records using the options below.
            </p>

        </div>


        <!-- Employee Management -->

        <h2>Employee Management</h2>

        <div class="dashboard">

            <!-- View Employees -->

            <div class="dashboard-card">

                <h3>View Employees</h3>

                <p>
                    View all employees and their details.
                </p>

                <a href="${pageContext.request.contextPath}/employees"
                   class="btn btn-primary">

                    View Employees

                </a>

            </div>


            <!-- Add Employee -->

            <div class="dashboard-card">

                <h3>Add Employee</h3>

                <p>
                    Add a new employee to the system.
                </p>

                <a href="${pageContext.request.contextPath}/employees"
                   class="btn btn-success">

                    Add Employee

                </a>

            </div>


            <!-- Update Employee -->

            <div class="dashboard-card">

                <h3>Update Employee</h3>

                <p>
                    Update existing employee information.
                </p>

                <a href="${pageContext.request.contextPath}/employees"
                   class="btn btn-secondary">

                    Update Employee

                </a>

            </div>


            <!-- Delete Employee -->

            <div class="dashboard-card">

                <h3>Delete Employee</h3>

                <p>
                    Remove an employee from the system.
                </p>

                <a href="${pageContext.request.contextPath}/employees"
                   class="btn btn-danger">

                    Delete Employee

                </a>

            </div>

        </div>


        <!-- Footer -->

        <div class="footer">

            Employee Management System

        </div>

    </div>

</body>

</html>