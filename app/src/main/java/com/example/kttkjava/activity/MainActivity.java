package com.example.kttkjava.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kttkjava.R;
import com.example.kttkjava.model.Supplier;
import com.example.kttkjava.controller.SupplierDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Create an instance of SupplierDAO
        SupplierDAO supplierDAO = new SupplierDAO();

        // Call the searchByName method with the dummy input "sea"
        ArrayList<Supplier> suppliers = supplierDAO.searchByName("sea");

        // Log the results
        for (Supplier supplier : suppliers) {
            Log.d("MainActivity", "Supplier ID: " + supplier.getId() + ", Name: " + supplier.getName());
        }
    }
}