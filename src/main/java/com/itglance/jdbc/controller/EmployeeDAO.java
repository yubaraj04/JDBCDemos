package com.itglance.jdbc.controller;

import com.itglance.jdbc.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {
    public int addEmployee(Employee employee) throws SQLException;

    public ArrayList<Employee> display() throws SQLException;

    public Employee findOne(long inputId) throws SQLException;

    public int deleteEmployee(Employee employee) throws SQLException;

    public int updateEmployee(Employee employee) throws SQLException;

    public Employee findByName(String inputName) throws SQLException;
}
