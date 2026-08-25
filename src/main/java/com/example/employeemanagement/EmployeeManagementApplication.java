package com.example.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.employeemanagement.filter.AuthenticationFilter;
import com.example.employeemanagement.servlet.EmployeeServlet;
import com.example.employeemanagement.servlet.HomeServlet;
import com.example.employeemanagement.servlet.LoginServlet;
import com.example.employeemanagement.servlet.LogoutServlet;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                EmployeeManagementApplication.class, args);

    }

    // Login Servlet
    @Bean
    public ServletRegistrationBean<LoginServlet> loginServlet() {

        ServletRegistrationBean<LoginServlet> registration =
                new ServletRegistrationBean<>(
                        new LoginServlet(),
                        "/login"
                );

        registration.setName("LoginServlet");

        return registration;
    }

    // Home Servlet
    @Bean
    public ServletRegistrationBean<HomeServlet> homeServlet() {

        ServletRegistrationBean<HomeServlet> registration =
                new ServletRegistrationBean<>(
                        new HomeServlet(),
                        "/home"
                );

        registration.setName("HomeServlet");

        return registration;
    }

    // Employee Servlet
    @Bean
    public ServletRegistrationBean<EmployeeServlet> employeeServlet() {

        ServletRegistrationBean<EmployeeServlet> registration =
                new ServletRegistrationBean<>(
                        new EmployeeServlet(),
                        "/employees"
                );

        registration.setName("EmployeeServlet");

        return registration;
    }

    // Logout Servlet
    @Bean
    public ServletRegistrationBean<LogoutServlet> logoutServlet() {

        ServletRegistrationBean<LogoutServlet> registration =
                new ServletRegistrationBean<>(
                        new LogoutServlet(),
                        "/logout"
                );

        registration.setName("LogoutServlet");

        return registration;
    }

    // Authentication Filter
    @Bean
    public FilterRegistrationBean<AuthenticationFilter>
            authenticationFilter() {

        FilterRegistrationBean<AuthenticationFilter> registration =
                new FilterRegistrationBean<>();

        registration.setFilter(new AuthenticationFilter());

        registration.addUrlPatterns(
                "/home",
                "/employees"
        );

        registration.setName("AuthenticationFilter");

        registration.setOrder(1);

        return registration;
    }
}