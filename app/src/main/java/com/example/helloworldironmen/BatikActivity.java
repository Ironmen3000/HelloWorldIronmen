package com.example.helloworldironmen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class BatikActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<BatikModel> mBatikModel;
    private BatikAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batik);

        mRecyclerView = findViewById(R.id.recyclerView);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mBatikModel = new ArrayList<>();
        mAdapter = new BatikAdapter(this, mBatikModel);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
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

    }

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