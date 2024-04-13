package com.example.kttkjava.controller;

import android.util.Log;

import com.example.kttkjava.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAO extends DAO {
    public SupplierDAO() {
        super();
    }

    public ArrayList<Supplier> searchByName(String name) {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String query = "SELECT * FROM suppliers WHERE name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String supplierName = rs.getString("name");
                String param3 = rs.getString("des");
                String param4 = rs.getString("address");
                String param5 = rs.getString("phone");
                String param6 = rs.getString("email");
                Supplier supplier = new Supplier(id, supplierName, param3, param4, param5, param6);
                suppliers.add(supplier);
            }
            closeConnection();
        } catch (SQLException e) {
            Log.v("Error: ", e.getMessage());
        }
        return suppliers;
    }

    public Supplier addSupplier(Supplier supplier) {
        try {
            Connection conn = getConnection();
            String query = "INSERT INTO suppliers (name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, supplier.getName());
            stmt.executeUpdate();
            closeConnection();
            return supplier;
        } catch (SQLException e) {
            Log.v("Error: ", e.getMessage());
            return null;
        }
    }

    public Supplier editSupplier(Supplier supplier) {
        try {
            Connection conn = getConnection();
            String query = "UPDATE suppliers SET name = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, supplier.getName());
            stmt.setInt(2, supplier.getId());
            stmt.executeUpdate();
            closeConnection();
            return supplier;
        } catch (SQLException e) {
            Log.v("Error: ", e.getMessage());
            return null;
        }
    }
}
