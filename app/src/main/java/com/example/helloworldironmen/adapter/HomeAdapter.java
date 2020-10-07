package com.example.helloworldironmen.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworldironmen.DetailActivity;
import com.example.helloworldironmen.R;
import com.example.helloworldironmen.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private List<HomeModel> homeModel = new ArrayList<>();

    public HomeAdapter(Context context, List<HomeModel> homeModel) {
        this.context = context;
        this.homeModel = homeModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        HomeModel homeModels = homeModel.get(position);
        holder.tvNamaBarang.setText(homeModels.getName());
        holder.tvQty.setText(String.valueOf(homeModels.getQuantity()));
        holder.cvKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("nama_barang", holder.tvNamaBarang.getText().toString().trim());
                intent.putExtra("qty", holder.tvQty.getText().toString().trim());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeModel.size();
    }

    public void updateData(List<HomeModel> groceryList) {
        this.homeModel = groceryList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNamaBarang;
        private TextView tvQty;
        private CardView cvKlik;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaBarang = itemView.findViewById(R.id.tv_nama_barang);
            tvQty = itemView.findViewById(R.id.tv_qty);
            cvKlik = itemView.findViewById(R.id.cv_klik);

        }
    }
}

