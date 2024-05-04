package com.example.kttkjava.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kttkjava.R;
import com.example.kttkjava.model.ChosenProduct;
import com.example.kttkjava.model.Product;
import com.example.kttkjava.model.PurchaseProduct;
import com.example.kttkjava.model.Supplier;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ProductImport extends AppCompatActivity {
    private TextInputEditText quantity;
    private Button checkOutButton, cancelButton;
    private TextView supplierName, productName;
    private Product product;
    private Supplier supplier;
    private ArrayList<ChosenProduct> chosenProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_import);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        setup();
    }

    private void init() {
        quantity = findViewById(R.id.quantity_input_edit_text);
        checkOutButton = findViewById(R.id.checkout_button);
        cancelButton = findViewById(R.id.cancel_button);
        supplierName = findViewById(R.id.supplier_name);
        productName = findViewById(R.id.product_name);
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        supplier = (Supplier) intent.getSerializableExtra("supplier");
        chosenProducts = (ArrayList<ChosenProduct>) intent.getSerializableExtra("chosen products");
        productName.setText(product.getName());
        supplierName.setText(supplier.getName());
    }
    private void setup() {
        checkOutButton.setOnClickListener(v -> {
            String quantityString = quantity.getText().toString();
            if (quantityString.isEmpty()) {
                return;
            }
            int quantity = Integer.parseInt(quantityString);
            if (quantity <= 0) {
                return;
            }

            ChosenProduct chosenProduct = new ChosenProduct(product.getId(),product.getName(),product.getDes(),product.getBuyPrice(),quantity,product.getBuyPrice()*quantity);
            if (chosenProducts == null) {
                chosenProducts = new ArrayList<>();
            }
            chosenProducts.add(chosenProduct);
            Intent intent = new Intent(this, ProductSearch.class);
            intent.putExtra("supplier",supplier);
            intent.putExtra("chosen products",chosenProducts);
            startActivity(intent);
        });
        cancelButton.setOnClickListener(v -> {
            finish();
        });
    }
}