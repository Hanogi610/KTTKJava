package com.example.kttkjava.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.activity.ProductSearch;
import com.example.kttkjava.model.Supplier;

import java.util.List;

public class SupplierSearchAdapter extends RecyclerView.Adapter<SupplierSearchAdapter.SupplierSearchViewHolder> {
    private List<Supplier> supplierList;
    private Context context;

    public SupplierSearchAdapter(List<Supplier> supplierList, Context context) {
        this.supplierList = supplierList;
        this.context = context;
    }

    @NonNull
    @Override
    public SupplierSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.supplier_search_item, parent, false);
        return new SupplierSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierSearchViewHolder holder, int position) {
        Supplier supplier = supplierList.get(position);
        holder.supplierName.setText(supplier.getName());

        // Set OnClickListener for the entire item view
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductSearch.class);
            intent.putExtra("supplier", supplier);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return supplierList.size();
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.supplierList = suppliers;
        notifyDataSetChanged();
    }

    public static class SupplierSearchViewHolder extends RecyclerView.ViewHolder {
        TextView supplierName;

        public SupplierSearchViewHolder(@NonNull View itemView) {
            super(itemView);
            supplierName = itemView.findViewById(R.id.supplier_name);
        }
    }
}