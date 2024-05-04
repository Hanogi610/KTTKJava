package com.example.kttkjava.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import com.example.kttkjava.R;
import com.example.kttkjava.model.ChosenProduct;

import java.util.ArrayList;

public class ChosenProductWORemoveBtnAdapter extends RecyclerView.Adapter<ChosenProductWORemoveBtnAdapter.ChosenProductViewHolder> {
    private ArrayList<ChosenProduct> chosenProducts;

    public ChosenProductWORemoveBtnAdapter(ArrayList<ChosenProduct> chosenProducts) {
        this.chosenProducts = chosenProducts;
    }

    @NonNull
    @Override
    public ChosenProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.no_remove_btn_product_rv_item, parent, false);
        return new ChosenProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChosenProductViewHolder holder, int position) {
        ChosenProduct chosenProduct = chosenProducts.get(position);
        holder.name.setText(chosenProduct.getName());
        holder.quantity.setText(String.valueOf(chosenProduct.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return chosenProducts != null ? chosenProducts.size() : 0;
    }

    static class ChosenProductViewHolder extends RecyclerView.ViewHolder {
        TextView name, quantity;

        public ChosenProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.chosen_product_name);
            quantity = itemView.findViewById(R.id.chosen_product_quantity);
        }
    }
}
