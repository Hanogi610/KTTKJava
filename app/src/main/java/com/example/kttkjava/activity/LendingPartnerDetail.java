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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.adapter.LPDetailPaymentRvAdapter;
import com.example.kttkjava.controller.AppDatabase;
import com.example.kttkjava.model.Address;
import com.example.kttkjava.model.LPStatistic;
import com.example.kttkjava.model.Name;
import com.example.kttkjava.model.Payment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LendingPartnerDetail extends AppCompatActivity {
    private TextView companyName, firstName, lastName,middleName, address;
    private RecyclerView paymentRv;
    private LPDetailPaymentRvAdapter adapter;
    private ArrayList<Payment> payments;
    private Name name;
    private Address addressObject;
    private Button okButton;
    private LPStatistic lpStatistic;
    private List<Payment> paymentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lending_partner_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        setup();
    }

    private void init() {
        companyName = findViewById(R.id.edit_company_name_textview);
        firstName = findViewById(R.id.edit_first_name_textview);
        lastName = findViewById(R.id.edit_last_name_textview);
        middleName = findViewById(R.id.edit_middle_name_textview);
        address = findViewById(R.id.address_textview);
        paymentRv = findViewById(R.id.lp_payment_rv);
        okButton = findViewById(R.id.ok_button);

        payments = new ArrayList<>();

        Intent intent = getIntent();
        lpStatistic = (LPStatistic) intent.getSerializableExtra("lpStatistic");
        new getInfor().execute();
    }
    private void setup() {
        okButton.setOnClickListener(v -> finish());
    }
    private class getInfor extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            AppDatabase instance = AppDatabase.getInstance(LendingPartnerDetail.this);
            name = instance.nameDao().getNameById(lpStatistic.getLendingPartner().getName_id());
            addressObject = instance.addressDao().getAddressById(lpStatistic.getLendingPartner().getAddress_id());
            paymentList = Arrays.asList(instance.paymentDAO().getAll());
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            companyName.setText(lpStatistic.getLendingPartner().getCompanyName());
            for(Payment payment : paymentList){
                if(payment.getLending_partner_id()==lpStatistic.getLendingPartner().getId()){
                    payments.add(payment);
                }
            }
            firstName.setText(name.getFirstName());
            lastName.setText(name.getLastName());
            middleName.setText(name.getMiddleName());
            address.setText(addressObject.getStreet() + ", " + addressObject.getDistrict() + ", " + addressObject.getCity() + ", " + addressObject.getProvince()+ ", " + addressObject.getCountry());
            adapter = new LPDetailPaymentRvAdapter(payments);
            paymentRv.setAdapter(adapter);
            paymentRv.setLayoutManager(new GridLayoutManager(LendingPartnerDetail.this,1));
        }
    }
    private class getPayment extends AsyncTask<Void, Void, Void >{

        @Override
        protected Void doInBackground(Void... voids) {
           return null;
        }
    }
}