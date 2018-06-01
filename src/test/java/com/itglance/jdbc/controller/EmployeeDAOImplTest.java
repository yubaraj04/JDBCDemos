package com.itglance.jdbc.controller;

import com.itglance.jdbc.common.DBConnection;
import com.itglance.jdbc.model.Employee;
import junit.framework.TestCase;

import java.sql.Connection;
import java.util.ArrayList;

public class EmployeeDAOImplTest extends TestCase {
    EmployeeDAO daoimpl = new EmployeeDAOImpl();

    public void testAddEmployee() throws Exception {

        Employee employee = new Employee();
        employee.setName("Ramesh");
        employee.setAddress("but");
        employee.setPhone("9876543215");
        employee.setSalary(45000);
        int i = daoimpl.addEmployee(employee);
        assertEquals(1, i);

    }


    public void testDisplay() throws Exception {

        ArrayList<Employee> list = daoimpl.display();
        if (list != null) {
            int i = 1;
            assertEquals(1, i);
        }

    }

    public void testFindOne() throws Exception {

        Employee employee = daoimpl.findOne(4);
        if (employee != null) {
            int i = 1;
            assertEquals(1, i);
        }
    }

    public void testDeleteEmployee() throws Exception {

        Employee employee = daoimpl.findOne(2);
        int i = daoimpl.deleteEmployee(employee);
        assertEquals(1, i);
    }


    public void testUpdateEmployee() throws Exception {
    Employee employee=daoimpl.findOne(4);
    if(employee !=null) {
        employee.setName("Ravin");
        employee.setAddress("Kapan");
        employee.setPhone("984562317");
        employee.setSalary(50000);

        int i = daoimpl.updateEmployee(employee);
        assertEquals(1, i);
    }
    }
}