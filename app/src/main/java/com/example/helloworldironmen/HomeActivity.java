package com.example.helloworldironmen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworldironmen.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rv;
    private HomeAdapter homeAdapter;
    private List<HomeModel> homeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        homeModels = new ArrayList<>();
        homeAdapter = new HomeAdapter(this, homeModels);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(homeAdapter);

        setData();

    }

    private void setData() {
        List<HomeModel> dummyData = HomeDataModel.groceryList();
        homeAdapter.updateData(dummyData);
    }

    private void initView() {
        rv = findViewById(R.id.home_id);
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

