package com.itglance.jdbc.controller;

import com.itglance.jdbc.model.Employee;
import com.itglance.jdbc.common.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    Connection con = DBConnection.getConnection();

    public int addEmployee(Employee employee) throws SQLException {

        String sql = "insert into `employeeinfo`(name,address,phone,salary) values(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        // pst.setLong(1,counter );
        pst.setString(1, employee.getName());
        pst.setString(2, employee.getAddress());
        pst.setString(3, employee.getPhone());
        pst.setInt(4, employee.getSalary());
        return pst.executeUpdate();
    }

    public ArrayList<Employee> display() throws SQLException {
        ArrayList<Employee> list = new ArrayList<Employee>();

        String sql = "Select * from `employeeinfo`";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setAddress(rs.getString("address"));
            employee.setPhone(rs.getString("phone"));
            employee.setSalary(rs.getInt("salary"));
            list.add(employee);
        }
        return list;
    }

    public Employee findOne(long inputId) throws SQLException {
        String sql = "SELECT * FROM employeeinfo WHERE id=" + inputId;
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Employee employee = new Employee();
        rs.next();
        employee.setId(rs.getLong("id"));
        employee.setName(rs.getString("name"));
        employee.setAddress(rs.getString("address"));
        employee.setPhone(rs.getString("phone"));
        employee.setSalary(rs.getInt("salary"));

        return employee;
    }

    public int deleteEmployee(Employee employee) throws SQLException {
        String sql = "DELETE  FROM employeeinfo WHERE id=" + employee.getId();
        PreparedStatement pst = con.prepareStatement(sql);
        return pst.executeUpdate();
    }

    public int updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employeeinfo  SET name=?, address=?,phone=?,salary=? where id=" + employee.getId();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, employee.getName());
        pst.setString(2, employee.getAddress());
        pst.setString(3, employee.getPhone());
        pst.setInt(4, employee.getSalary());

        return pst.executeUpdate();
    }
    public Employee findByName(String inputName) throws SQLException {
        String sql = "SELECT * FROM `employeeinfo` WHERE name LIKE '%"+inputName+"%'";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getLong("id"));
            employee.setName(resultSet.getString("name"));
            employee.setAddress(resultSet.getString("address"));
            employee.setPhone(resultSet.getString("phone"));
            employee.setSalary(resultSet.getInt("salary"));
            return employee;
        }
      return null;
    }

}