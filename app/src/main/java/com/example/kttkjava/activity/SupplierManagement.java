package com.example.kttkjava.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.adapter.SupplierAdapter;
import com.example.kttkjava.model.Supplier;
import com.example.kttkjava.repository.SupplierRepository;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SupplierManagement extends AppCompatActivity {
    private RecyclerView supplierRecyclerView;
    private MaterialButton searchButton,addNewSupplierButton;
    private TextInputEditText searchInput;
    private SupplierAdapter supplierAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupplierManagement.this, MainActivity.class);
                startActivity(intent);
            }
        });
        init();
        setup();

    }

    private void setup() {
        searchButton.setOnClickListener(v -> {
            String searchInput = this.searchInput.getText().toString();
            new FetchSupplierByNameTask().execute(searchInput);
        });
        addNewSupplierButton.setOnClickListener(v -> {
            Intent intent = new Intent(SupplierManagement.this, AddNewSupplier.class);
            startActivity(intent);
        });
    }

    private void init(){
        supplierRecyclerView = findViewById(R.id.supplier_list);
        searchButton = findViewById(R.id.search_button);
        addNewSupplierButton = findViewById(R.id.add_new_supllier_button);
        searchInput = findViewById(R.id.search_supplier_text);
        new FetchSuppliersTask().execute();
    }
    private class FetchSuppliersTask extends AsyncTask<Void, Void, List<Supplier>> {
        @Override
        protected List<Supplier> doInBackground(Void... voids) {
            return Arrays.asList(MainActivity.instance.supplierDAO().getAllSuppliers());
        }

        @Override
        protected void onPostExecute(List<Supplier> suppliers) {
            supplierAdapter = new SupplierAdapter(suppliers, SupplierManagement.this);
            supplierRecyclerView.setAdapter(supplierAdapter);
            supplierRecyclerView.setLayoutManager(new LinearLayoutManager(SupplierManagement.this));
        }
    }

    private class FetchSupplierByNameTask extends AsyncTask<String, Void, List<Supplier>> {
        @Override
        protected List<Supplier> doInBackground(String... strings) {
            List<Supplier> suppliers = Arrays.asList(MainActivity.instance.supplierDAO().getSupplierByName(strings[0]));
            return suppliers;
        }

        @Override
        protected void onPostExecute(List<Supplier> suppliers) {
            //Log.d("FetchSupplierByNameTask", "Setting suppliers: " + suppliers);
            supplierAdapter.setSuppliers(suppliers);
        }
    }
}