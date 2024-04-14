package com.example.kttkjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.kttkjava.R;
import com.example.kttkjava.controller.AppDatabase;
import com.example.kttkjava.controller.AppDatabaseCallback;
import com.example.kttkjava.model.Supplier;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static AppDatabase instance;
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
        instance = AppDatabase.getInstance(this);
//        Supplier a = new Supplier("supplier a","supllier a","hn vn","0","ss@gmail.com");
//        new insertSupplier().execute(a);
        supplierManagementButton = findViewById(R.id.supplier);
        importProductButton = findViewById(R.id.import_product);
        statisticButton = findViewById(R.id.lpstatistic);

        supplierManagementButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SupplierManagement.class);
            startActivity(intent);
        });
        importProductButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SupplierManagement.class);
            startActivity(intent);
        });
        statisticButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Statistic.class);
            startActivity(intent);
        });
    }

//    class insertSupplier extends AsyncTask<Supplier,Void, Void>{
//        @Override
//        protected Void doInBackground(Supplier... notes) {
//            instance.supplierDAO().insert(notes[0]);
//
//            return null;
//        }
//    }
}
