package com.example.helloworldironmen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batik);

      /*  mRecyclerView = findViewById(R.id.recyclerView);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mBatikModel = new ArrayList<>();
        mAdapter = new BatikAdapter(this, mBatikModel);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();*/
        initView();
        getData();
    }

   /* private void initializeData() {
        String[] BatikList = getResources()
                .getStringArray(R.array.Batik_titles);
        String[] BatikInfo = getResources()
                .getStringArray(R.array.Batik_info);
        TypedArray BatikImageResources = getResources()
                .obtainTypedArray(R.array.Batik_images);

        for (int i = 0; i < BatikList.length; i++) {
            mBatikModel.add(new BatikModel(BatikList[i], BatikInfo[i],
                    BatikImageResources.getResourceId(i, 0)));
        }

    } */


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

        return true;
    }
}