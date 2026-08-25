<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Employee Management - Employees</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="container">

    <!-- Header -->

    <div class="header">

        <h1>Employee Management System</h1>

        <p>
            Manage employee records
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


    <!-- Success Message -->

    <%
        String success =
                (String) session.getAttribute("success");

        if (success != null) {
    %>

        <div class="success-message">

            <%= success %>

        </div>

    <%
            session.removeAttribute("success");
        }
    %>


    <!-- Error Message -->

    <%
        String error =
                (String) request.getAttribute("error");

        if (error != null) {
    %>

        <div class="error-message">

            <%= error %>

        </div>

    <%
        }
    %>


    <!-- Add Employee -->

    <div class="card">

        <h2>Add Employee</h2>

        <form action="${pageContext.request.contextPath}/employees"
              method="post">

            <div class="form-group">

                <label for="name">
                    Name
                </label>

                <input type="text"
                       id="name"
                       name="name"
                       placeholder="Enter employee name"
                       required>

            </div>


            <div class="form-group">

                <label for="email">
                    Email
                </label>

                <input type="email"
                       id="email"
                       name="email"
                       placeholder="Enter email address"
                       required>

            </div>


            <div class="form-group">

                <label for="department">
                    Department
                </label>

                <input type="text"
                       id="department"
                       name="department"
                       placeholder="Enter department"
                       required>

            </div>


            <div class="form-group">

                <label for="salary">
                    Salary
                </label>

                <input type="number"
                       id="salary"
                       name="salary"
                       placeholder="Enter salary"
                       step="0.01"
                       min="0"
                       required>

            </div>


            <button type="submit"
                    class="btn btn-success">

                + Add Employee

            </button>

        </form>

    </div>


    <!-- Employee List -->

    <div class="card">

        <h2>Employee List</h2>

        <c:choose>

            <c:when test="${not empty employees}">

                <table class="employee-table">

                    <thead>

                        <tr>

                            <th>ID</th>

                            <th>Name</th>

                            <th>Email</th>

                            <th>Department</th>

                            <th>Salary</th>

                            <th>Actions</th>

                        </tr>

                    </thead>


                    <tbody>

                        <c:forEach var="employee"
                                   items="${employees}">

                            <tr>

                                <td>
                                    ${employee.id}
                                </td>

                                <td>
                                    ${employee.name}
                                </td>

                                <td>
                                    ${employee.email}
                                </td>

                                <td>
                                    ${employee.department}
                                </td>

                                <td>
                                    ₹${employee.salary}
                                </td>

                                <td>

                                    <div class="action-buttons">

                                        <!-- Edit -->

                                        <a href="${pageContext.request.contextPath}/employees?action=edit&id=${employee.id}"
                                           class="btn btn-primary">

                                            Edit

                                        </a>


                                        <!-- Delete -->

                                        <a href="${pageContext.request.contextPath}/employees?action=delete&id=${employee.id}"
                                           class="btn btn-danger"
                                           onclick="return confirm('Are you sure you want to delete this employee?');">

                                            Delete

                                        </a>

                                    </div>

                                </td>

                            </tr>

                        </c:forEach>

                    </tbody>

                </table>

            </c:when>


            <c:otherwise>

                <p>
                    No employees found.
                </p>

            </c:otherwise>

        </c:choose>

    </div>


    <!-- Navigation Buttons -->

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