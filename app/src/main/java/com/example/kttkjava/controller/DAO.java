package com.example.kttkjava.controller;

import android.os.Debug;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String DATABASE_URL = "jdbc:mysql://192.168.0.101:3306/bnpl";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "123456";
    private Connection conn;

    public Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        return conn;
    }
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            Log.v("Error: ", e.getMessage());
        }
    }
}