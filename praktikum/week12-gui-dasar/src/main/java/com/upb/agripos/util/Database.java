package com.upb.agripos.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:5432/agripos",
                "root",
                ""
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
