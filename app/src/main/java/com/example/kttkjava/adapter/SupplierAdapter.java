package com.example.kttkjava.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.activity.EditSupplier;
import com.example.kttkjava.model.Supplier;

import java.util.List;

public class SupplierAdapter extends RecyclerView.Adapter<SupplierViewHolder> {
    private List<Supplier> supplierList;
    private Context context;

    public SupplierAdapter(List<Supplier> supplierList, Context context) {
        this.supplierList = supplierList;
        this.context = context;
    }

    @NonNull
    @Override
    public SupplierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.supplier_list_item, parent, false);
        return new SupplierViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierViewHolder holder, int position) {
        Supplier supplier = supplierList.get(position);
        holder.supplierName.setText(supplier.getName());
        holder.editButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, EditSupplier.class);
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
}
class SupplierViewHolder extends RecyclerView.ViewHolder {
    TextView supplierName;
    ImageButton editButton;

    public SupplierViewHolder(@NonNull View itemView) {
        super(itemView);
        supplierName = itemView.findViewById(R.id.item_supplier_name);
        editButton = itemView.findViewById(R.id.item_edit_button);
    }
}