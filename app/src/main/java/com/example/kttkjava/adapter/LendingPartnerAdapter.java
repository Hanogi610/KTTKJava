package com.example.kttkjava.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kttkjava.R;
import com.example.kttkjava.activity.LendingPartnerDetail;
import com.example.kttkjava.model.LPStatistic;
import com.example.kttkjava.model.LendingPartner;

import java.util.List;

public class LendingPartnerAdapter extends RecyclerView.Adapter<LendingPartnerViewHolder> {
    private List<LPStatistic> lendingPartnerList;

    public LendingPartnerAdapter(List<LPStatistic> lendingPartnerList) {
        this.lendingPartnerList = lendingPartnerList;
    }

    @NonNull
    @Override
    public LendingPartnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.statistic_list_item, parent, false);
        return new LendingPartnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LendingPartnerViewHolder holder, int position) {
        LPStatistic lendingPartner = lendingPartnerList.get(position);
        holder.lendingPartnerName.setText(lendingPartner.getName() +" : " + lendingPartner.getRevenue());
        holder.detailButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), LendingPartnerDetail.class);
            intent.putExtra("lpStatistic", lendingPartner);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lendingPartnerList.size();
    }
}
class LendingPartnerViewHolder extends RecyclerView.ViewHolder {
    TextView lendingPartnerName;
    Button detailButton;

    public LendingPartnerViewHolder(@NonNull View itemView) {
        super(itemView);
        lendingPartnerName = itemView.findViewById(R.id.statistic_name);
        detailButton = itemView.findViewById(R.id.detail_button);
    }

}
