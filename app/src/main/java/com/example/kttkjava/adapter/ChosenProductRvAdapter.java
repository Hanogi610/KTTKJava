package com.example.kttkjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.activity.SupplierSearch;
import com.example.kttkjava.model.ChosenProduct;

import java.util.ArrayList;

public class ChosenProductRvAdapter extends RecyclerView.Adapter<ChosenProductRvAdapter.ChosenProductViewHolder> {
    private ArrayList<ChosenProduct> chosenProducts;
    private Context context;
    private OnRemoveClickListener listener;

    public ChosenProductRvAdapter(ArrayList<ChosenProduct> chosenProducts, Context context) {
        this.chosenProducts = chosenProducts;
        this.context = context;
    }

    @NonNull
    @Override
    public ChosenProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chosen_product_rv_item, parent, false);
        return new ChosenProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChosenProductViewHolder holder, int position) {
        ChosenProduct chosenProduct = chosenProducts.get(position);
        holder.name.setText(chosenProduct.getName());
        holder.quantity.setText(String.valueOf(chosenProduct.getQuantity()));
        holder.removeButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onRemoveClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chosenProducts != null ? chosenProducts.size() : 0;
    }

    public interface OnRemoveClickListener {
        void onRemoveClick(int position);
    }

    public void setOnRemoveClickListener(OnRemoveClickListener listener) {
        this.listener = listener;
    }

    static class ChosenProductViewHolder extends RecyclerView.ViewHolder {
        private TextView name, quantity;
        private Button removeButton;

        public ChosenProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.chosen_product_name);
            quantity = itemView.findViewById(R.id.chosen_product_quantity);
            removeButton = itemView.findViewById(R.id.chosen_product_remove_button);
        }
    }
}


