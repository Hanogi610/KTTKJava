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
import com.example.kttkjava.adapter.LendingPartnerAdapter;
import com.example.kttkjava.controller.AppDatabase;
import com.example.kttkjava.model.LPStatistic;
import com.example.kttkjava.model.LendingPartner;
import com.example.kttkjava.model.Name;
import com.example.kttkjava.model.Payment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Statistic extends AppCompatActivity {
    private LendingPartnerAdapter lendingPartnerAdapter;
    private RecyclerView recyclerView;
    private List<LendingPartner> lendingPartnerList;
    private List<Payment> paymentList;
    private List<LPStatistic> lpStatisticList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_statistic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Statistic.this, MainActivity.class);
                startActivity(intent);
            }
        });
        lpStatisticList = new ArrayList<>();
        recyclerView = findViewById(R.id.statistic_list);
        new initialize().execute();
    }

    private class initialize extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            lendingPartnerList = Arrays.asList(AppDatabase.getInstance(getApplicationContext()).lendingPartnerDAO().getAllLendingPartners());
            Payment[] lpPayment = AppDatabase.getInstance(getApplicationContext()).paymentDAO().getAll();
            for(LendingPartner lendingPartner : lendingPartnerList) {
                float revenue = 0;
                for(Payment payment : lpPayment) {
                    if(payment.getLending_partner_id() == lendingPartner.getId()) {
                        revenue += payment.getAmount();
                    }
                }
                Name name = AppDatabase.getInstance(getApplicationContext()).nameDao().getNameById(lendingPartner.getName_id());
                String nameString = name.getFirstName() + " " + name.getLastName() + " - " + lendingPartner.getCompanyName();
                lpStatisticList.add(new LPStatistic(nameString , revenue, lendingPartner));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            lpStatisticList.sort((LPStatistic lp1, LPStatistic lp2) -> Float.compare(lp2.getRevenue(), lp1.getRevenue()));
            LendingPartnerAdapter lendingPartnerAdapter = new LendingPartnerAdapter(lpStatisticList);
            recyclerView.setAdapter(lendingPartnerAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(Statistic.this));
        }
    }
}