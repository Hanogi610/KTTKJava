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

public class EditSupplier extends AppCompatActivity {
    private Supplier supplier;
    private TextInputEditText suplierName, supplierPhone, supplierEmail, supplierAddress, supplierDescription;
    private Button editUpdateButton,editResetButton,editCancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_supplier);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        setup();
    }

    private void setup() {
        editResetButton.setOnClickListener(v -> {
            suplierName.setText(supplier.getName());
            supplierPhone.setText(supplier.getPhone());
            supplierEmail.setText(supplier.getEmail());
            supplierAddress.setText(supplier.getAddress());
            supplierDescription.setText(supplier.getDes());
        });
        editCancelButton.setOnClickListener(v -> {
            finish();
        });
        editUpdateButton.setOnClickListener(v -> {
            supplier.setName(suplierName.getText().toString());
            supplier.setPhone(supplierPhone.getText().toString());
            supplier.setEmail(supplierEmail.getText().toString());
            supplier.setAddress(supplierAddress.getText().toString());
            supplier.setDes(supplierDescription.getText().toString());
            new UpdateSupplierTask().execute(supplier);
        });
    }

    private void init() {
        suplierName = findViewById(R.id.edit_supplier_name);
        supplierPhone = findViewById(R.id.edit_supplier_phone);
        supplierEmail = findViewById(R.id.edit_supplier_email);
        supplierAddress = findViewById(R.id.edit_supplier_address);
        supplierDescription = findViewById(R.id.edit_supplier_des);
        editUpdateButton = findViewById(R.id.edit_update_button);
        editResetButton = findViewById(R.id.edit_reset_button);
        editCancelButton = findViewById(R.id.edit_cancel_button);
        supplier = (Supplier) getIntent().getSerializableExtra("supplier");
        suplierName.setText(supplier.getName());
        supplierPhone.setText(supplier.getPhone());
        supplierEmail.setText(supplier.getEmail());
        supplierAddress.setText(supplier.getAddress());
        supplierDescription.setText(supplier.getDes());
    }
    private class UpdateSupplierTask extends AsyncTask<Supplier,Void,Void> {
        @Override
        protected Void doInBackground(Supplier... suppliers) {
            AppDatabase.getInstance(getApplicationContext()).supplierDAO().update(suppliers[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(EditSupplier.this, "Updated succesfully", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}