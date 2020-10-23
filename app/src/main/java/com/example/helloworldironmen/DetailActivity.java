package com.example.helloworldironmen;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivDetail;
    private TextView tvPenjelasan;
    private TextView tvDaerah;
    private TextView tvaHargaRendah;
    private TextView tvaHargaTinggi;
    private int hargaRendah;
    private int hargaTinggi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle(getIntent().getStringExtra("nama_batik"));
        tvPenjelasan.setText(getIntent().getStringExtra("makna_batik"));
        tvDaerah.setText("Asal Daerah Batik: " + getIntent().getStringExtra( "daerah_batik"));
        tvaHargaRendah.setText("Harga Terendah Batik: Rp  " + (getIntent().getIntExtra("harga_rendah", hargaRendah)));
        tvaHargaTinggi.setText("Harga Tertinggi Batik: Rp  " + (getIntent().getIntExtra("harga_tinggi", hargaTinggi)));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("link_batik")).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(ivDetail);


    }

    private void initView() {
        ivDetail = findViewById(R.id.iv_detail);
        tvPenjelasan = findViewById(R.id.tv_penjelasan);
        tvDaerah = findViewById(R.id.tv_daerah);
        tvaHargaRendah = findViewById(R.id.tv_hargarendah);
        tvaHargaTinggi = findViewById(R.id.tv_hargatinggi);
    }
}