package com.example.kttkjava.activity;

import android.os.AsyncTask;
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
import com.example.kttkjava.model.Supplier;
import com.google.android.material.textfield.TextInputEditText;

public class AddNewSupplier extends AppCompatActivity {

    private TextInputEditText addSupplierName, addSupplierPhone, addSupplierEmail, addSupplierAddress, addSupplierDescription;
    private Button addSupplierButton, addCancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_supplier);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        setup();
    }

    private void setup() {
        addCancelButton.setOnClickListener(v -> {
            finish();
        });
        addSupplierButton.setOnClickListener(v -> {
            addSupplier();
        });
    }

    private void init() {
        addSupplierAddress = findViewById(R.id.add_supplier_address);
        addSupplierDescription = findViewById(R.id.add_supplier_description);
        addSupplierEmail = findViewById(R.id.add_supplier_email);
        addSupplierName = findViewById(R.id.add_supplier_name);
        addSupplierPhone = findViewById(R.id.add_supplier_phone);
        addSupplierButton = findViewById(R.id.add_supplier_button);
        addCancelButton = findViewById(R.id.add_cancel_button);
    }

    private void addSupplier() {
        String name = addSupplierName.getText().toString();
        String phone = addSupplierPhone.getText().toString();
        String email = addSupplierEmail.getText().toString();
        String address = addSupplierAddress.getText().toString();
        String description = addSupplierDescription.getText().toString();
        if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        Supplier supplier = new Supplier(name, phone, email, address, description);
        new AddSupplierTask().execute(supplier);
    }
    private class AddSupplierTask extends AsyncTask<Supplier, Void, Void> {
        @Override
        protected Void doInBackground(Supplier... suppliers) {
            Supplier supplier = suppliers[0];
            AppDatabase.getInstance(getApplicationContext()).supplierDAO().insert(supplier);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            finish();
        }
    }
}