package com.example.kttkjava.activity;

import android.content.Context;
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
        instance = getInstance(this);
        supplierManagementButton = findViewById(R.id.supplier);
    }

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "BNPL_database")
                    .addCallback(new AppDatabaseCallback(context.getApplicationContext()))
                    .build();
        }
        return instance;
    }

}
