package com.example.helloworldironmen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class MenuActivity extends AppCompatActivity {

    private MaterialCardView cvTempatWisata;
    private MaterialCardView cvDaftarHotel;
    private MaterialCardView cvProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();

        cvTempatWisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), tempatwisata.class));
            }
        });

        cvDaftarHotel.setOnClickListener(new View.OnClickListener() {
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
        cvTempatWisata = (MaterialCardView) findViewById(R.id.cv_tempatwisata);
        cvDaftarHotel = (MaterialCardView) findViewById(R.id.cv_daftarhotel);
        cvProfil = (MaterialCardView) findViewById(R.id.cv_profil);
    }
}