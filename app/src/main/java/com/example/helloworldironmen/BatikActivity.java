package com.example.helloworldironmen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworldironmen.model.HasilItem;
import com.example.helloworldironmen.model.RootBatikModel;
import com.example.helloworldironmen.rest.ApiConfig;
import com.example.helloworldironmen.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BatikActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<HasilItem> hasilItems;
    private BatikAdapter batikAdapter;
    private RadioButton mrdiNotification,rdiToast;
    private Button mbtnOneTime,mbtnRepeating;
    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batik);

        initView();
        getData();
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);



/*
       mbtnOneTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mrdiNotification.isChecked()) {
                    startAlarm(true, false);
                } else
                    startAlarm(false, false);
            }
        });

        mbtnRepeating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mrdiNotification.isChecked()) {
                    startAlarm(true,true);
                } else
                    startAlarm(false,true);
            }
        }); */



    }





    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData()
                .enqueue(new Callback<RootBatikModel>() {
                    @Override
                    public void onResponse(Call<RootBatikModel> call, Response<RootBatikModel> response) {
                        if(response.isSuccessful()){
                            hasilItems = (ArrayList<HasilItem>) response.body().getHasil();
                            batikAdapter = new BatikAdapter(hasilItems, getApplicationContext());
                            batikAdapter.notifyDataSetChanged();
                            rv.setAdapter(batikAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        }
                    }

                    @Override
                    public void onFailure(Call<RootBatikModel> call, Throwable t) {
                        Toast.makeText(BatikActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
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