package com.example.kttkjava.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kttkjava.R;
import com.example.kttkjava.model.Employee;
import com.example.kttkjava.model.PurchaseInvoice;
import com.example.kttkjava.model.Shipment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class PurchaseInvoiceActivity extends AppCompatActivity {
    private TextView supplier, address,total, product;
    private Button confirm, cancel;
    private int employeeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_purchase_invoice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        setup();
    }

    private void init() {
        supplier = findViewById(R.id.supplier_textview);
        address = findViewById(R.id.address_textview);
        total = findViewById(R.id.total_textview);
        product = findViewById(R.id.product_amount_textview);
        confirm = findViewById(R.id.confirm_button);
        cancel = findViewById(R.id.cancel_button);
        Intent intent = getIntent();
        supplier.setText(ProductSearch.purchaseSuppplier.getName());
        Shipment shipment = (Shipment) intent.getSerializableExtra("shipment");
        address.setText(shipment.getDes());

        // Generate a random number between 50 and 150
        Random random = new Random();
        int randomNumber = random.nextInt(101) + 50; // This will generate a random number between 50 and 150

        // Add the random number to the cost of the purchase product
        float totalCost = Shipping.purchaseProduct.getCost() + randomNumber;

        // Set the total cost as the text of the total TextView
        total.setText(String.valueOf(totalCost));
        product.setText(ProductImport.product.getName() + " x " + Shipping.purchaseProduct.getQuantity());
    }
    private void setup() {
        confirm.setOnClickListener(v -> {
            // Create a new PurchaseInvoice object
            float totalCost = Float.parseFloat(total.getText().toString());
            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            int purchaseProductId = Shipping.purchaseProduct.getId();
            int supplierId = ProductSearch.purchaseSuppplier.getId();
            Intent intent = getIntent();
            Shipment shipment = (Shipment) intent.getSerializableExtra("shipment");
            int shipmentId = shipment.getId();
            new getEmployee().execute();; // This is a placeholder for the employee ID

            PurchaseInvoice purchaseInvoice = new PurchaseInvoice(totalCost, date, purchaseProductId, supplierId, shipmentId, employeeId);

            // Execute the saveInvoice AsyncTask
            new saveInvoice().execute(purchaseInvoice);
        });
        cancel.setOnClickListener(v -> {
            finish();
        });
    }
    private class getEmployee extends AsyncTask<Void, Void, Employee>{
        @Override
        protected Employee doInBackground(Void... voids) {
            return MainActivity.instance.employeeDao().getAllEmployee()[0];
        }

        @Override
        protected void onPostExecute(Employee employee) {
            employeeId = employee.getId();
        }
    }
    private class saveInvoice extends AsyncTask<PurchaseInvoice,Void,Void>{
        @Override
        protected Void doInBackground(PurchaseInvoice... purchaseInvoices) {
            MainActivity.instance.purchaseInvoiceDAO().insert(purchaseInvoices[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Toast.makeText(PurchaseInvoiceActivity.this, "Invoice saved successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PurchaseInvoiceActivity.this, SupplierSearch.class);
            startActivity(intent);
        }
    }
}