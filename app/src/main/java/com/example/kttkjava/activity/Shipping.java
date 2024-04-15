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
import com.example.kttkjava.controller.ShipmentDAO;
import com.example.kttkjava.model.Product;
import com.example.kttkjava.model.PurchaseInvoice;
import com.example.kttkjava.model.PurchaseProduct;
import com.example.kttkjava.model.Shipment;
import com.example.kttkjava.model.Supplier;
import com.google.android.material.textfield.TextInputEditText;

public class Shipping extends AppCompatActivity {
    private TextInputEditText shippingAddress;
    private TextView product, quantity, supplier;
    private Button confirmButton, cancelButton;
    private PurchaseProduct purchaseProduct;
    private Product productObject;
    private Supplier supplierObject;

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
        product = findViewById(R.id.product_textview);
        quantity = findViewById(R.id.quantity_textview);
        supplier = findViewById(R.id.supplier_textview);
        confirmButton = findViewById(R.id.confirm_button);
        cancelButton = findViewById(R.id.cancel_button);
        Intent intent = getIntent();
        purchaseProduct = (PurchaseProduct) intent.getSerializableExtra("purchaseProduct");
        productObject = (Product) intent.getSerializableExtra("product");
        supplierObject = (Supplier) intent.getSerializableExtra("supplier");
        product.setText(productObject.getName());
        quantity.setText(String.valueOf(purchaseProduct.getQuantity()));
        supplier.setText(supplierObject.getName());
    }
    private void setup() {
        confirmButton.setOnClickListener(v -> {
            String shippingAddressString = shippingAddress.getText().toString();
            if (shippingAddressString.isEmpty()) {
                return;
            }
            Shipment shipment = new Shipment(productObject.getName(), shippingAddressString);
            new addShipment().execute(shipment);

        });
        cancelButton.setOnClickListener(v -> {
            finish();
        });
    }
    private class addShipment extends AsyncTask<Shipment, Void, Shipment> {

        @Override
        protected Shipment doInBackground(Shipment... shipments) {
            long id = MainActivity.instance.shipmentDAO().insert(shipments[0]);
            return MainActivity.instance.shipmentDAO().getShipmentById(id);
        }

        @Override
        protected void onPostExecute(Shipment shipment) {
            Intent intent = new Intent(Shipping.this, PurchaseInvoiceActivity.class);
            intent.putExtra("shipment",shipment);
            intent.putExtra("purchaseProduct",purchaseProduct);
            intent.putExtra("product",productObject);
            intent.putExtra("supplier",supplierObject);
            startActivity(intent);
        }
    }
}