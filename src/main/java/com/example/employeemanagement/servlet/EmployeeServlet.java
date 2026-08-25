package com.example.employeemanagement.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.employeemanagement.dao.EmployeeDAO;
import com.example.employeemanagement.model.Employee;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    // Email validation pattern
    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // Edit Employee
        if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            List<Employee> employees =
                    employeeDAO.getAllEmployees();

            Employee selectedEmployee = null;

            for (Employee employee : employees) {

                if (employee.getId() == id) {
                    selectedEmployee = employee;
                    break;
                }
            }

            if (selectedEmployee == null) {

                request.getSession().setAttribute(
                        "success",
                        "Employee not found."
                );

                response.sendRedirect(
                        request.getContextPath() + "/employees"
                );

                return;
            }

            request.setAttribute(
                    "employee",
                    selectedEmployee
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/edit-employee.jsp")
                   .forward(request, response);

        // Delete Employee
        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            employeeDAO.deleteEmployee(id);

            request.getSession().setAttribute(
                    "success",
                    "Employee deleted successfully!"
            );

            response.sendRedirect(
                    request.getContextPath() + "/employees"
            );

        // Display Employees
        } else {

            List<Employee> employees =
                    employeeDAO.getAllEmployees();

            request.setAttribute(
                    "employees",
                    employees
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/employees.jsp")
                   .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // Common employee details
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department =
                request.getParameter("department");

        /*
         * NAME VALIDATION
         */
        if (name == null || name.trim().isEmpty()) {

            showError(
                    request,
                    response,
                    "Invalid name. Name cannot be empty."
            );

            return;
        }

        name = name.trim();

        if (!name.matches("[A-Za-z ]+")) {

            showError(
                    request,
                    response,
                    "Invalid name. Name should contain only letters and spaces."
            );

            return;
        }

        /*
         * DEPARTMENT VALIDATION
         */
        if (department == null ||
                department.trim().isEmpty()) {

            showError(
                    request,
                    response,
                    "Invalid department. Department cannot be empty."
            );

            return;
        }

        department = department.trim();

        /*
         * EMAIL VALIDATION
         */
        if (email == null ||
                email.trim().isEmpty()) {

            showError(
                    request,
                    response,
                    "Invalid email. Email cannot be empty."
            );

            return;
        }

        email = email.trim();

        if (!Pattern.matches(EMAIL_PATTERN, email)) {

            showError(
                    request,
                    response,
                    "Invalid email format. Please enter a valid email."
            );

            return;
        }

        /*
         * SALARY VALIDATION
         */
        String salaryValue =
                request.getParameter("salary");

        double salary;

        try {

            salary = Double.parseDouble(salaryValue);

            if (salary < 0) {

                showError(
                        request,
                        response,
                        "Invalid salary. Salary cannot be negative."
                );

                return;
            }

        } catch (NumberFormatException e) {

            showError(
                    request,
                    response,
                    "Invalid salary. Please enter a valid number."
            );

            return;
        }

        /*
         * UPDATE EMPLOYEE
         */
        if ("update".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            Employee employee = new Employee();

            employee.setId(id);
            employee.setName(name);
            employee.setEmail(email);
            employee.setDepartment(department);
            employee.setSalary(salary);

            employeeDAO.updateEmployee(employee);

            request.getSession().setAttribute(
                    "success",
                    "Employee updated successfully!"
            );

        /*
         * ADD EMPLOYEE
         */
        } else {

            Employee employee = new Employee();

            employee.setName(name);
            employee.setEmail(email);
            employee.setDepartment(department);
            employee.setSalary(salary);

            employeeDAO.addEmployee(employee);

            request.getSession().setAttribute(
                    "success",
                    "Employee added successfully!"
            );
        }

        response.sendRedirect(
                request.getContextPath() + "/employees"
        );
    }

    // Display validation error
    private void showError(HttpServletRequest request,
                           HttpServletResponse response,
                           String message)
            throws ServletException, IOException {

        request.setAttribute(
                "error",
                message
        );

        List<Employee> employees =
                employeeDAO.getAllEmployees();

        request.setAttribute(
                "employees",
                employees
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/employees.jsp")
               .forward(request, response);
    }
}