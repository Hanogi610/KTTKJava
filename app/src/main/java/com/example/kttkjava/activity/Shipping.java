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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.adapter.ChosenProductRvAdapter;
import com.example.kttkjava.adapter.ChosenProductWORemoveBtnAdapter;
import com.example.kttkjava.controller.ShipmentDAO;
import com.example.kttkjava.model.ChosenProduct;
import com.example.kttkjava.model.Product;
import com.example.kttkjava.model.PurchaseInvoice;
import com.example.kttkjava.model.PurchaseProduct;
import com.example.kttkjava.model.Shipment;
import com.example.kttkjava.model.Supplier;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Shipping extends AppCompatActivity {
    private TextInputEditText shippingAddress;
    private TextView  supplier;
    private Button confirmButton, cancelButton;
    private Supplier supplierObject;
    private ChosenProductWORemoveBtnAdapter chosenProductRvAdapter;
    private RecyclerView chosenProductRv;
    private ArrayList<ChosenProduct> chosenProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shipping);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        setup();
    }

    private void init() {
        shippingAddress = findViewById(R.id.shipping_address_edittext);
        supplier = findViewById(R.id.supplier_textview);
        confirmButton = findViewById(R.id.confirm_button);
        cancelButton = findViewById(R.id.cancel_button);
        chosenProductRv = findViewById(R.id.chosen_product_rv);


        Intent intent = getIntent();
        supplierObject = (Supplier) intent.getSerializableExtra("supplier");
        chosenProducts = (ArrayList<ChosenProduct>) intent.getSerializableExtra("chosen products");
        supplier.setText(supplierObject.getName());

        chosenProductRvAdapter = new ChosenProductWORemoveBtnAdapter(chosenProducts);
        chosenProductRv.setAdapter(chosenProductRvAdapter);
        chosenProductRv.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setup() {
        confirmButton.setOnClickListener(v -> {
            String shippingAddressString = shippingAddress.getText().toString();
            if (shippingAddressString.isEmpty()) {
                return;
            }
            Shipment shipment = new Shipment(shippingAddressString, String.valueOf(chosenProducts.size())+" products");
            Intent intent = new Intent(Shipping.this, PurchaseInvoiceActivity.class);
            intent.putExtra("shipment",shipment);
            intent.putExtra("supplier",supplierObject);
            intent.putExtra("chosen products",chosenProducts);
            startActivity(intent);

        });
        cancelButton.setOnClickListener(v -> {
            finish();
        });
    }
}