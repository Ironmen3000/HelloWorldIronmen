package com.example.helloworldironmen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivDetail;
    private TextView tvAlamat;
    private TextView tvKoordinat;
    private TextView tvTelepon;
    private TextView tvTitle;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle(getIntent().getStringExtra("nama_hotel"));
        tvTitle.setText(getIntent().getStringExtra("nama_hotel"));
        tvAlamat.setText(getIntent().getStringExtra("alamat_hotel"));
        tvTelepon.setText("Nomor Telepon: " + getIntent().getStringExtra("nomor_telp"));
        tvKoordinat.setText("Koordinat: " + getIntent().getStringExtra( "koordinat"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("gambar_url")).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(ivDetail);
    }

    private void initView() {
        ivDetail = findViewById(R.id.iv_detail);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvKoordinat = findViewById(R.id.tv_koordinat);
        tvTitle = findViewById(R.id.tv_title);
        tvTelepon = findViewById(R.id.tv_telepon);


    }
}