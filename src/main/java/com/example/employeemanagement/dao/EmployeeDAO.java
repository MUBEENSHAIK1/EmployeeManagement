package com.example.employeemanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.employeemanagement.model.Employee;

public class EmployeeDAO {

    // Get all employees
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setSalary(resultSet.getDouble("salary"));

                employees.add(employee);
            }

        } catch (SQLException e) {

            System.err.println(
                    "Error while fetching employees: "
                    + e.getMessage()
            );
        }

        return employees;
    }


    // Add new employee
    public boolean addEmployee(Employee employee) {

        String sql = "INSERT INTO employee "
                   + "(name, email, department, salary) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {

            System.err.println(
                    "Error while adding employee: "
                    + e.getMessage()
            );

            return false;
        }
    }


    // Update employee
    public boolean updateEmployee(Employee employee) {

        String sql = "UPDATE employee "
                   + "SET name = ?, email = ?, department = ?, salary = ? "
                   + "WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());
            statement.setInt(5, employee.getId());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {

            System.err.println(
                    "Error while updating employee: "
                    + e.getMessage()
            );

            return false;
        }
    }


    // Delete employee
    public boolean deleteEmployee(int id) {

        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {

            System.err.println(
                    "Error while deleting employee: "
                    + e.getMessage()
            );

            return false;
        }
    }
}