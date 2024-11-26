package com.example.demo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static final String URL = "jdbc:postgresql://localhost:5432/university";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1359";

    private static Connection conn;

    public static Connection connect() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conn;
    }


    public static void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (name, surname, position, phonenumber, type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connect().prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSurname());
            stmt.setString(3, employee.getPosition());
            stmt.setString(4, employee.getPhonenumber());
            stmt.setString(5, employee.getType().toString());
            stmt.executeUpdate();
        }
    }

    // Get all employees from the database
    public static List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setPosition(rs.getString("position"));
                employee.setPhonenumber(rs.getString("phonenumber"));
                employee.setType(Employeetype.valueOf(rs.getString("gender")));
                employee.setSalary(rs.getInt()
                employees.add(employee);
            }
        }
        return employees;
    }


    public static Employee getEmployeeById(int id) throws SQLException {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connect().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setSurname(rs.getString("surname"));
                    employee.setPosition(rs.getString("position"));
                    employee.setPhonenumber(rs.getString("phonenumber"));
                    employee.setType(Employeetype.valueOf(rs.getString("type")));
                }
            }
        }
        return employee;
    }


    public static void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET name = ?, surname = ?, position = ?, phonenumber = ?, type = ? WHERE id = ?";
        try (PreparedStatement stmt = connect().prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSurname());
            stmt.setString(3, employee.getPosition());
            stmt.setString(4, employee.getPhonenumber());
            stmt.setString(5, employee.getType().toString());
            stmt.setInt(6, employee.getId());
            stmt.executeUpdate();
        }
    }


    public static void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connect().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    public static void addEmployeeType(Employeetype type) throws SQLException {
        String sql = "INSERT INTO employee_types (type_name) VALUES (?)";
        try (PreparedStatement stmt = connect().prepareStatement(sql)) {
            stmt.setString(1, type.toString());
            stmt.executeUpdate();
        }
    }


    public static List<Employeetype> getAllEmployeeTypes() throws SQLException {
        List<Employeetype> types = new ArrayList<>();
        String sql = "SELECT * FROM employee_types";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                types.add(Employeetype.valueOf(rs.getString("type_name")));
            }
        }
        return types;
    }
}
