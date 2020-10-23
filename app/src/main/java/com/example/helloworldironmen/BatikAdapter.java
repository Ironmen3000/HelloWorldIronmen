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
import com.example.helloworldironmen.model.HasilItem;

import java.util.ArrayList;

public class BatikAdapter extends RecyclerView.Adapter<BatikAdapter.ViewHolder> {

    private ArrayList<HasilItem> hasilItems;
    private Context context;



    public BatikAdapter(ArrayList<HasilItem> hasilItems, Context context){
        this.hasilItems = hasilItems;
        this.context = context;
    }

    @NonNull
    @Override
    public BatikAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BatikAdapter.ViewHolder holder, final int position) {
        holder.tvTitle.setText(hasilItems.get(position).getNamaBatik());
        holder.tvPenjelasan.setText("Asal Daerah: " + hasilItems.get(position).getDaerahBatik());
        Glide.with(context).load(hasilItems.get(position).getLinkBatik()).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(holder.iv);

       holder.cvKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("nama_batik", hasilItems.get(position).getNamaBatik());
                intent.putExtra("makna_batik", hasilItems.get(position).getMaknaBatik());
                intent.putExtra("link_batik", hasilItems.get(position).getLinkBatik());
                intent.putExtra("daerah_batik", hasilItems.get(position).getDaerahBatik());
                intent.putExtra("harga_rendah", hasilItems.get(position).getHargaRendah());
                intent.putExtra("harga_tinggi", hasilItems.get(position).getHargaTinggi());
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
        private TextView tvPenjelasan;
        private CardView cvKlik;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPenjelasan = itemView.findViewById(R.id.tv_penjelasan);
            cvKlik = itemView.findViewById(R.id.cv_klik);
        }

    }



}