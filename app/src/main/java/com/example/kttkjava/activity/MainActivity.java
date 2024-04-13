package com.example.kttkjava.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

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
    private Button supplierManagementButton;

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

        supplierManagementButton = findViewById(R.id.supplier);

        // Create an instance of SupplierDAO
        SupplierDAO supplierDAO = new SupplierDAO();

        supplierManagementButton.setOnClickListener(v -> {
            new LoadSuppliersTask().execute("Sea");
        });
    }

    private class LoadSuppliersTask extends AsyncTask<String, Void, ArrayList<Supplier>> {
        @Override
        protected ArrayList<Supplier> doInBackground(String... strings) {
            return new SupplierDAO().getAllSuppliers();
        }

        @Override
        protected void onPostExecute(ArrayList<Supplier> suppliers) {
            super.onPostExecute(suppliers);
            // Update UI on main thread
            Log.d("MainActivity", "Suppliers: " + suppliers.size());
        }
    }
}
