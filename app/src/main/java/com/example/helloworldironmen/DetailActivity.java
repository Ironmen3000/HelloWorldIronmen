package com.example.helloworldironmen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {

    private TextView tvNamaBarang;
    private TextView tvQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        tvNamaBarang.setText(getIntent().getStringExtra("nama_barang"));
        tvQty.setText(getIntent().getStringExtra("qty"));

    }

    private void initView() {
        tvNamaBarang = findViewById(R.id.tv_nama_barang);
        tvQty = findViewById(R.id.tv_qty);
    }
}
