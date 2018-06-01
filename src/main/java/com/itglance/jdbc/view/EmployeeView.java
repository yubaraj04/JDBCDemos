package com.itglance.jdbc.view;

import com.itglance.jdbc.controller.EmployeeDAO;
import com.itglance.jdbc.controller.EmployeeDAOImpl;
import com.itglance.jdbc.model.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeView {
    Scanner scanner = new Scanner(System.in);
    String continues, name, address, phone;
    int salary;
    EmployeeDAO daoimpl = new EmployeeDAOImpl();

    public void display() {
        do {
            System.out.println("1.Add Employee \n 2.Delete Employee \n 3.Update Employee \n 4.Display All \n 5.Search Employee By Id " +
                    " \n 6.Search Employee by name  ");
            System.out.println("Select an option:");
            switch (scanner.nextInt()) {

                case 1: {
                    System.out.println("Add");
                    System.out.println("Please supply your details.");
                    System.out.println("Enter your name:");
                    name = scanner.next();
                    System.out.println("Enter your address:");
                    address = scanner.next();
                    System.out.println("Enter your phone number:");
                    phone = scanner.next();
                    System.out.println("Enter your salary");
                    salary = scanner.nextInt();

                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setAddress(address);
                    employee.setPhone(phone);
                    employee.setSalary(salary);
                    try {
                        int i = daoimpl.addEmployee(employee);
                        if (i == 1) {
                            System.out.println("Employee added successfully !!");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 2: {
                    System.out.println("Delete");
                    System.out.println("Enter ID of Employee to be deleted:");
                    try {
                        Employee employee = daoimpl.findOne(scanner.nextLong());
                        int i = daoimpl.deleteEmployee(employee);
                        if (i == 1) {
                            System.out.println("Employee deleted successfully !!");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Update");
                    System.out.println("Enter id of Employee to be updated:");
                    System.out.println("");
                    try {
                        Employee employee = daoimpl.findOne(scanner.nextLong());
                        if (employee != null) {
                            System.out.println("Enter First Name:");
                            name = scanner.next();
                            System.out.println("Enter Address:");
                            address = scanner.next();
                            System.out.println("Enter Phone Number:");
                            phone = scanner.next();
                            System.out.println("Enter Salary:");
                            salary = scanner.nextInt();

                            employee.setName(name);
                            employee.setAddress(address);
                            employee.setPhone(phone);
                            employee.setSalary(salary);
                        }
                        int i = daoimpl.updateEmployee(employee);
                        if (i == 1) {
                            System.out.println("Employee information updated successfully !!");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Display");
                    try {
                        ArrayList<Employee> list = daoimpl.display();
                        for (Employee employee : list) {
                            System.out.println("Id:" + employee.getId() + "\n Name:" + employee.getName() + "\n Address:" + employee.getAddress()
                                    + "\n Phone:" + employee.getPhone() + "\n Salary:" + employee.getSalary());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Search by id");
                    System.out.println("Enter the id of Employee you want to search for:");
                    try {
                        Employee employee = daoimpl.findOne(scanner.nextLong());
                        if (employee != null) {
                            System.out.println("Employee found.");

                            System.out.println("Id:" + employee.getId() + "\n Name:" + employee.getName() + "\n Address:" + employee.getAddress()
                                    + "\n Phone:" + employee.getPhone() + "\n Salary:" + employee.getSalary());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6:{
                    System.out.println("Search by Name");
                    System.out.println("Enter the name of Employee you want to search for:");
                  try  {
                        Employee employee=daoimpl.findByName(scanner.next());
                        if(employee !=null){
                            System.out.println("Employee found.");
                            System.out.println("Id:" + employee.getId() + "\n Name:" + employee.getName() + "\n Address:" + employee.getAddress()
                                    + "\n Phone:" + employee.getPhone() + "\n Salary:" + employee.getSalary());
                            System.out.println("");
                        }
                    }catch(Exception e){
                      System.out.println(e.getMessage());
                  }
                  break;
                }
                default: {
                    System.out.println("Invalid Selection");
                }
            }
            System.out.println("Do you want to continue? (y/n) ");
            continues = scanner.next();
        } while (continues.equalsIgnoreCase("y") || continues.equalsIgnoreCase("yes"));
    }
}
