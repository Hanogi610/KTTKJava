package com.example.kttkjava.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.adapter.ChosenProductRvAdapter;
import com.example.kttkjava.adapter.ProductAdapter;
import com.example.kttkjava.controller.AppDatabase;
import com.example.kttkjava.model.ChosenProduct;
import com.example.kttkjava.model.Product;
import com.example.kttkjava.model.Supplier;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSearch extends AppCompatActivity {
    private TextInputEditText searchInput;
    private MaterialButton searchButton, addNewProductButton,returnButton;
    private ProductAdapter productAdapter;
    private RecyclerView productRecyclerView;
    private List<Product> products;
    private Supplier purchaseSuppplier;
    private Button checkOutButton;
    private ChosenProductRvAdapter chosenProductRvAdapter;
    private RecyclerView chosenProductRv;
    private ArrayList<ChosenProduct> chosenProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        setup();
    }

    private void setup() {
        searchButton.setOnClickListener(v -> {
            String search = searchInput.getText().toString();
            new searchProduct().execute(search);

        });
        addNewProductButton.setOnClickListener(v -> {
            // Start the AddProduct activity
             Intent intent = new Intent(this, NewProduct.class);
             startActivity(intent);
        });
        returnButton.setOnClickListener(v -> {
            finish();
        });
        checkOutButton.setOnClickListener(v -> {
            // Start the ProductImport activity
            if(chosenProducts.size() == 0){
                Toast.makeText(this, "Please choose at least one product", Toast.LENGTH_SHORT).show();
                return;
            }else {
                Intent intent = new Intent(this, Shipping.class);
                intent.putExtra("supplier", purchaseSuppplier);
                intent.putExtra("chosen products", chosenProducts);
                startActivity(intent);
            }
        });
    }

    private void init() {
        Intent intent = getIntent();
        purchaseSuppplier = (Supplier) intent.getSerializableExtra("supplier");
        chosenProducts = (ArrayList<ChosenProduct>) intent.getSerializableExtra("chosen products");

        searchInput = findViewById(R.id.search_product_name);
        searchButton = findViewById(R.id.product_search_button);
        addNewProductButton = findViewById(R.id.add_new_product_button);
        returnButton = findViewById(R.id.return_button);
        productRecyclerView = findViewById(R.id.product_list);
        checkOutButton = findViewById(R.id.checkout_button);

        products = new ArrayList<>();
        productAdapter = new ProductAdapter(products, purchaseSuppplier,this);
        productRecyclerView.setAdapter(productAdapter);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter.setOnItemClickListener(position -> {
            Product product = products.get(position);
            Intent intent1 = new Intent(this, ProductImport.class);
            intent1.putExtra("product", product);
            intent1.putExtra("supplier", purchaseSuppplier);
            intent1.putExtra("chosen products", chosenProducts);
            startActivity(intent1);
        });

        chosenProductRv = findViewById(R.id.chosen_product_rv);
        chosenProductRvAdapter = new ChosenProductRvAdapter(chosenProducts, this);
        chosenProductRv.setAdapter(chosenProductRvAdapter);
        chosenProductRv.setLayoutManager(new LinearLayoutManager(this));
        chosenProductRvAdapter.setOnRemoveClickListener(position -> {
            chosenProducts.remove(position);
            chosenProductRvAdapter.notifyItemRemoved(position);
        });

    }

    private class searchProduct extends AsyncTask<String, Void, List<Product>> {
        @Override
        protected List<Product> doInBackground(String... strings) {
            List<Product> products = Arrays.asList(AppDatabase.getInstance(getApplicationContext()).productDAO().getProductByName(strings[0]));
            Log.d("ProductSearch", "doInBackground: " + products.size());
            return products;
        }

        @Override
        protected void onPostExecute(List<Product> products) {
            productAdapter.setProducts(products);
            productAdapter.setOnItemClickListener(position -> {
                Product product = products.get(position);
                Intent intent1 = new Intent(getApplicationContext(), ProductImport.class);
                intent1.putExtra("product", product);
                intent1.putExtra("supplier", purchaseSuppplier);
                intent1.putExtra("chosen products", chosenProducts);
                startActivity(intent1);
            });
        }
    }
}