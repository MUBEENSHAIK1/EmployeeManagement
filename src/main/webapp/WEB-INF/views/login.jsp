<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Employee Management - Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="login-container">

        <div class="login-card">

            <h2>Employee Management System</h2>

            <p class="subtitle">
                Sign in to continue
            </p>

            <!-- Display Login Error -->

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

            <!-- Login Form -->

            <form action="${pageContext.request.contextPath}/login"
                  method="post">

                <div class="form-group">

                    <label for="username">
                        Username
                    </label>

                    <input type="text"
                           id="username"
                           name="username"
                           placeholder="Enter username"
                           required>

                </div>


                <div class="form-group">

                    <label for="password">
                        Password
                    </label>

                    <input type="password"
                           id="password"
                           name="password"
                           placeholder="Enter password"
                           required>

                </div>


                <button type="submit"
                        class="btn btn-primary"
                        style="width: 100%;">

                    Login

                </button>

            </form>

        </div>

        <div class="footer">

            Employee Management System

        </div>

    </div>

</body>

</html>