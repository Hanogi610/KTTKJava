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
import com.example.kttkjava.model.Address;
import com.example.kttkjava.model.LPStatistic;
import com.example.kttkjava.model.Name;

public class LendingPartnerDetail extends AppCompatActivity {
    private TextView companyName, firstName, lastName,middleName, address,revenue;
    private Name name;
    private Address addressObject;
    private Button okButton;
    private LPStatistic lpStatistic;

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
        revenue = findViewById(R.id.edit_revenue_textview);
        okButton = findViewById(R.id.ok_button);
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
            name = MainActivity.instance.nameDao().getNameById(lpStatistic.getLendingPartner().getName_id());
            addressObject = MainActivity.instance.addressDao().getAddressById(lpStatistic.getLendingPartner().getAddress_id());
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            companyName.setText(lpStatistic.getLendingPartner().getCompanyName());
            revenue.setText(String.valueOf(lpStatistic.getRevenue()));
            firstName.setText(name.getFirstName());
            lastName.setText(name.getLastName());
            middleName.setText(name.getMiddleName());
            address.setText(addressObject.getStreet() + ", " + addressObject.getDistrict() + ", " + addressObject.getCity() + ", " + addressObject.getProvince()+ ", " + addressObject.getCountry());
        }
    }
}