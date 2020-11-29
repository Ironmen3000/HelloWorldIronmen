package com.example.helloworldironmen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class MenuActivity extends AppCompatActivity {

    private MaterialCardView cvSejarah;
    private MaterialCardView cvDaftarBatik;
    private MaterialCardView cvProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();

        cvSejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SejarahBatik.class));
            }
        });

        cvDaftarBatik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HotelActivity.class));
            }
        });
        cvProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfilActivity.class));
            }
        });

    }

    private void initView() {
        cvSejarah = (MaterialCardView) findViewById(R.id.cv_sejarah);
        cvDaftarBatik = (MaterialCardView) findViewById(R.id.cv_daftarbatik);
        cvProfil = (MaterialCardView) findViewById(R.id.cv_profil);
    }
}