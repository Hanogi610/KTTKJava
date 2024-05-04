package com.example.kttkjava.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.model.Payment;

import java.util.ArrayList;

public class LPDetailPaymentRvAdapter extends RecyclerView.Adapter<LPDetailPaymentRvAdapter.PaymentViewHolder>{
    private ArrayList<Payment> payments;

    public LPDetailPaymentRvAdapter(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.payment_rv_item, null);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        Payment payment = payments.get(position);
        holder.name.setText(payment.getName());
        holder.amount.setText(String.valueOf(payment.getAmount()));
    }

    @Override
    public int getItemCount() {
        return payments != null ? payments.size() : 0;
    }

    static class PaymentViewHolder extends RecyclerView.ViewHolder {
        TextView name, amount;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.payment_date);
            amount = itemView.findViewById(R.id.payment_amount);
        }
    }
}
