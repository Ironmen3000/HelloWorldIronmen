package com.example.helloworldironmen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworldironmen.model.HotelItem;
import com.example.helloworldironmen.model.RootHotelModel;
import com.example.helloworldironmen.rest.ApiConfig;
import com.example.helloworldironmen.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<HotelItem> hasilItems;
    private HotelAdapter hotelAdapter;
    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        initView();
        getData();
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);







    }





    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData()
                .enqueue(new Callback<RootHotelModel>() {
                    @Override
                    public void onResponse(Call<RootHotelModel> call, Response<RootHotelModel> response) {
                        if(response.isSuccessful()){
                            hasilItems = (ArrayList<HotelItem>) response.body().getHotel();
                            hotelAdapter = new HotelAdapter(hasilItems, getApplicationContext());
                            hotelAdapter.notifyDataSetChanged();
                            rv.setAdapter(hotelAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        }
                    }

                    @Override
                    public void onFailure(Call<RootHotelModel> call, Throwable t) {
                        Toast.makeText(HotelActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }




    // Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_about){
            startActivity(new Intent(this, ProfilActivity.class));
        }
        if (item.getItemId()==R.id.alarm){
            startActivity(new Intent(this, Alarm.class));
        }


        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.apply();
    }


}