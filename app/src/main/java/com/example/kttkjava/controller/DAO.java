package com.example.kttkjava.controller;

import android.os.Debug;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String DATABASE_URL = "jdbc:mysql://192.168.0.101:3306/bnpl";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "123456";
    private Connection conn;

    public DAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            if (conn != null && !conn.isClosed()) {
                Log.d("DAO", "Connected to MySQL server successfully.");
            } else {
                Log.d("DAO", "Failed to connect to MySQL server.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            Log.e("DAO", "Error connecting to MySQL server: " + e.getMessage());
        }
    }

    protected Connection getConnection() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
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