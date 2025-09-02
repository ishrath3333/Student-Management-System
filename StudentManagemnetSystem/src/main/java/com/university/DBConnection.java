package com.university;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Connect to database
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university_db", "root", "inas");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
