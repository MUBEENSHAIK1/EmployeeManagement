package com.example.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.employeemanagement.servlet.LoginServlet;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<LoginServlet> loginServlet() {

        ServletRegistrationBean<LoginServlet> registration =
                new ServletRegistrationBean<>(new LoginServlet(), "/login");

        registration.setName("LoginServlet");

        return registration;
    }
}