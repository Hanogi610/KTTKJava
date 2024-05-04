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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.adapter.ChosenProductRvAdapter;
import com.example.kttkjava.adapter.ChosenProductWORemoveBtnAdapter;
import com.example.kttkjava.controller.AppDatabase;
import com.example.kttkjava.model.ChosenProduct;
import com.example.kttkjava.model.Employee;
import com.example.kttkjava.model.Product;
import com.example.kttkjava.model.PurchaseInvoice;
import com.example.kttkjava.model.PurchaseProduct;
import com.example.kttkjava.model.Shipment;
import com.example.kttkjava.model.Supplier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class PurchaseInvoiceActivity extends AppCompatActivity {
    private TextView supplier, address,total;
    private Button confirm, cancel;
    private RecyclerView product;
    private int employeeId;
    private Shipment shipment;
    private Supplier supplierObject;
    private ChosenProductWORemoveBtnAdapter adapter;
    private ArrayList<ChosenProduct> chosenProducts;
    private PurchaseInvoice purchaseInvoice;

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
        confirm = findViewById(R.id.confirm_button);
        cancel = findViewById(R.id.cancel_button);
        product = findViewById(R.id.purchase_invoice_list);

        Intent intent = getIntent();
        shipment = (Shipment) intent.getSerializableExtra("shipment");
        supplierObject = (Supplier) intent.getSerializableExtra("supplier");
        chosenProducts = (ArrayList<ChosenProduct>) intent.getSerializableExtra("chosen products");

        adapter = new ChosenProductWORemoveBtnAdapter(chosenProducts);
        product.setAdapter(adapter);
        product.setLayoutManager(new LinearLayoutManager(this));

        supplier.setText(supplierObject.getName());

        address.setText(shipment.getDes());

        Random random = new Random();
        float totalCost = random.nextInt(101) + 50;
        for(ChosenProduct chosenProduct : chosenProducts){
            totalCost += chosenProduct.getCost();
        }
        total.setText(String.valueOf(totalCost));


    }
    private void setup() {
        confirm.setOnClickListener(v -> {
            // Create a new PurchaseInvoice object
            float totalCost = Float.parseFloat(total.getText().toString());
            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            int supplierId = supplierObject.getId();
            Intent intent = getIntent();
            Shipment shipment = (Shipment) intent.getSerializableExtra("shipment");
            int shipmentId = shipment.getId();
            //new getEmployee().execute();; // This is a placeholder for the employee ID

            purchaseInvoice = new PurchaseInvoice(totalCost, date, supplierId, shipmentId, 1);

            // Execute the saveInvoice AsyncTask
            new saveInvoice().execute();
        });
        cancel.setOnClickListener(v -> {
            finish();
        });
    }
    private class getEmployee extends AsyncTask<Void, Void, Employee>{
        @Override
        protected Employee doInBackground(Void... voids) {
            return AppDatabase.getInstance(getApplicationContext()).employeeDao().getAllEmployee()[0];
        }

        @Override
        protected void onPostExecute(Employee employee) {
            employeeId = employee.getId();
        }
    }
    private class saveInvoice extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            AppDatabase instance = AppDatabase.getInstance(getApplicationContext());
            long id = instance.shipmentDAO().insert(shipment);
            Shipment s = instance.shipmentDAO().getShipmentById((int) id);
            purchaseInvoice.setShipment_id(s.getId());
            purchaseInvoice.setId((int) instance.purchaseInvoiceDAO().insert(purchaseInvoice));
            for(ChosenProduct chosenProduct : chosenProducts){
                PurchaseProduct purchaseProduct = new PurchaseProduct(
                        chosenProduct.getProduct_id(),
                        chosenProduct.getQuantity(),
                        chosenProduct.getCost(),
                        purchaseInvoice.getId()
                );
                instance.purchaseProductDAO().insert(purchaseProduct);
            }
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