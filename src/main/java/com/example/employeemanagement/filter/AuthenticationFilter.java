package com.example.employeemanagement.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                          ServletResponse response,
                          FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();

        HttpSession session =
                httpRequest.getSession(false);

        boolean loggedIn =
                session != null
                && session.getAttribute("username") != null;

        boolean loginRequest =
                requestURI.equals(contextPath + "/login");

        boolean logoutRequest =
                requestURI.equals(contextPath + "/logout");

        /*
         * Allow the request when:
         * 1. User is already logged in
         * 2. User is trying to access login
         * 3. User is trying to logout
         */
        if (loggedIn || loginRequest || logoutRequest) {

            chain.doFilter(request, response);

        } else {

            // User is not logged in
            httpResponse.sendRedirect(
                    contextPath + "/login"
            );
        }
    }
}