package com.example.kttkjava.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kttkjava.R;
import com.example.kttkjava.controller.AppDatabase;
import com.example.kttkjava.controller.InitializeDatabaseTask;

public class MainActivity extends AppCompatActivity {
    public static AppDatabase instance;
    private Button supplierManagementButton,importProductButton, statisticButton;

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
        initializeDatabase();
        supplierManagementButton = findViewById(R.id.supplier);
        importProductButton = findViewById(R.id.import_product);
        statisticButton = findViewById(R.id.lpstatistic);

        supplierManagementButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SupplierManagement.class);
            startActivity(intent);
        });
        importProductButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SupplierSearch.class);
            startActivity(intent);
        });
        statisticButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Statistic.class);
            startActivity(intent);
        });
    }

    private void initializeDatabase() {
        try {
            instance = AppDatabase.getInstance(this);
            //new InitializeDatabaseTask(this).execute();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the initialization failure, e.g., show an error message
            Toast.makeText(this, "Failed to initialize database", Toast.LENGTH_SHORT).show();
        }
    }
}
