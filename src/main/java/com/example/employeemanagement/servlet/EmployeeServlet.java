package com.example.employeemanagement.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.employeemanagement.dao.EmployeeDAO;
import com.example.employeemanagement.model.Employee;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        List<Employee> employees = employeeDAO.getAllEmployees();

        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/WEB-INF/views/employees.jsp")
               .forward(request, response);
    }
}