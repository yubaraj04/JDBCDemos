package com.itglance.jdbc.common;

import java.sql.Connection;
import java.sql.*;

public class DBConnection {
    static final String url = "jdbc:mysql://localhost:3306/employeedemo";

    static final String userName = "root";
    static final String password = "";

    public static final Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
