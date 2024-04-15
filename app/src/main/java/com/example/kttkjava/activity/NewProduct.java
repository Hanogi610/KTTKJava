package com.example.kttkjava.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kttkjava.R;
import com.example.kttkjava.model.Product;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class NewProduct extends AppCompatActivity {
    private TextInputEditText productName, productPrice, productDescription;
    private MaterialButton addProductButton,cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        setup();
    }

    private void init() {
        productName = findViewById(R.id.add_product_name_input);
        productPrice = findViewById(R.id.add_product_price_input);
        productDescription = findViewById(R.id.add_product_des_input);
        addProductButton = findViewById(R.id.add_product_button);
        cancelButton = findViewById(R.id.cancel_button);
    }
    private void setup() {
        addProductButton.setOnClickListener(v -> {
            String name = productName.getText().toString();
            String price = productPrice.getText().toString();
            String description = productDescription.getText().toString();
            if (name.isEmpty() || price.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            // Add validation for price to ensure it's a valid float
            float buyPrice;
            try {
                buyPrice = Float.parseFloat(price);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter a valid price", Toast.LENGTH_SHORT).show();
                return;
            }
            Product a = new Product(name, description, buyPrice);
            new AddProductTask().execute(a);
        });
        cancelButton.setOnClickListener(v -> {
            finish();
        });
    }
    private class AddProductTask extends AsyncTask<Product, Void, Void> {

        @Override
        protected Void doInBackground(Product... products) {
            MainActivity.instance.productDAO().insert(products[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(NewProduct.this, "Add product succesfully", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}