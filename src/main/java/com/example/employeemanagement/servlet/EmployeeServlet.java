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

    private EmployeeDAO employeeDAO;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("edit".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            List<Employee> employees = employeeDAO.getAllEmployees();

            Employee selectedEmployee = null;

            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    selectedEmployee = employee;
                    break;
                }
            }

            request.setAttribute("employee", selectedEmployee);

            request.getRequestDispatcher("/WEB-INF/views/edit-employee.jsp")
                   .forward(request, response);

        } else {

            List<Employee> employees = employeeDAO.getAllEmployees();

            request.setAttribute("employees", employees);

            request.getRequestDispatcher("/WEB-INF/views/employees.jsp")
                   .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("update".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            Employee employee = new Employee();

            employee.setId(id);
            employee.setName(name);
            employee.setEmail(email);
            employee.setDepartment(department);
            employee.setSalary(salary);

            employeeDAO.updateEmployee(employee);

        } else {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            Employee employee = new Employee();

            employee.setName(name);
            employee.setEmail(email);
            employee.setDepartment(department);
            employee.setSalary(salary);

            employeeDAO.addEmployee(employee);
        }

        response.sendRedirect(request.getContextPath() + "/employees");
    }
}