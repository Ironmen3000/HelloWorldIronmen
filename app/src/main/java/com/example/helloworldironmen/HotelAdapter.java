package com.example.helloworldironmen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.helloworldironmen.model.HotelItem;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private ArrayList<HotelItem> hasilItems;
    private Context context;




    public HotelAdapter(ArrayList<HotelItem> hasilItems, Context context){
        this.hasilItems = hasilItems;
        this.context = context;
    }


    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder holder, final int position) {
        holder.tvTitle.setText(hasilItems.get(position).getNama());
        holder.tvTelepon.setText("No Telepon: " + hasilItems.get(position).getNomorTelp());
        holder.tvAlamat.setText(hasilItems.get(position).getAlamat());
        Glide.with(context).load(hasilItems.get(position).getGambarUrl()).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(holder.iv);

        holder.cvKlik.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("nama_hotel", hasilItems.get(position).getNama());
                intent.putExtra("nomor_telp", hasilItems.get(position).getNomorTelp());
                intent.putExtra("alamat_hotel", hasilItems.get(position).getAlamat());
                intent.putExtra("gambar_url", hasilItems.get(position).getGambarUrl());
                intent.putExtra("koordinat", hasilItems.get(position).getKordinat());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return hasilItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tvTitle;
        private TextView tvTelepon;
        private TextView tvAlamat;
        private CardView cvKlik;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvTelepon = itemView.findViewById(R.id.tv_telepon);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            cvKlik = itemView.findViewById(R.id.cv_klik);
        }

    }

}