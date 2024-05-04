package com.example.kttkjava.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.adapter.ChosenProductRvAdapter;
import com.example.kttkjava.adapter.SupplierAdapter;
import com.example.kttkjava.adapter.SupplierSearchAdapter;
import com.example.kttkjava.controller.AppDatabase;
import com.example.kttkjava.model.ChosenProduct;
import com.example.kttkjava.model.Product;
import com.example.kttkjava.model.Supplier;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SupplierSearch extends AppCompatActivity {
    private RecyclerView supplierRecyclerView;
    private MaterialButton searchButton,addNewSupplierButton;
    private TextInputEditText searchInput;
    private SupplierSearchAdapter supplierAdapter;

    private ArrayList<ChosenProduct> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_search);
        FloatingActionButton fab = findViewById(R.id.fab);

        products = new ArrayList<ChosenProduct>();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupplierSearch.this, MainActivity.class);
                intent.putExtra("chosen products", products);
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
            // Start the AddSupplier activity
            Intent intent = new Intent(this, AddNewSupplier.class);
            startActivity(intent);
        });

    }

    private void init(){
        searchInput = findViewById(R.id.search_supplier_text);
        searchButton = findViewById(R.id.search_button);
        addNewSupplierButton = findViewById(R.id.add_new_supllier_button);
        supplierRecyclerView = findViewById(R.id.supplier_list);


        new FetchSuppliersTask().execute();
    }
    private class FetchSuppliersTask extends AsyncTask<Void, Void, List<Supplier>> {
        @Override
        protected List<Supplier> doInBackground(Void... voids) {
            return Arrays.asList(AppDatabase.getInstance(getApplicationContext()).supplierDAO().getAllSuppliers());
        }

        @Override
        protected void onPostExecute(List<Supplier> suppliers) {
            supplierAdapter = new SupplierSearchAdapter(suppliers, SupplierSearch.this);
            supplierRecyclerView.setAdapter(supplierAdapter);
            supplierRecyclerView.setLayoutManager(new LinearLayoutManager(SupplierSearch.this));
        }
    }

    private class FetchSupplierByNameTask extends AsyncTask<String, Void, List<Supplier>> {
        @Override
        protected List<Supplier> doInBackground(String... strings) {
            List<Supplier> suppliers = Arrays.asList(AppDatabase.getInstance(getApplicationContext()).supplierDAO().getSupplierByName(strings[0]));
            return suppliers;
        }

        @Override
        protected void onPostExecute(List<Supplier> suppliers) {
            //Log.d("FetchSupplierByNameTask", "Setting suppliers: " + suppliers);
            supplierAdapter.setSuppliers(suppliers);
        }
    }
}