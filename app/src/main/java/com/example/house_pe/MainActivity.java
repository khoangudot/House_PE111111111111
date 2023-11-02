package com.example.house_pe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.house_pe.Activities.CreateHouseActivity;
import com.example.house_pe.Adapters.HouseAdapter;
import com.example.house_pe.Data.HouseDBHelper;
import com.example.house_pe.Models.HouseModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context;
    ArrayList<HouseModel> houseModels;
    RecyclerView carRecyclerView;
    HouseAdapter houseAdapter;
    Button btnAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List House");
        getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        houseModels = new ArrayList<>();
        carRecyclerView = findViewById(R.id.main_RecyclerView);
        btnAddNew =findViewById(R.id.main_btnAddNew);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, CreateHouseActivity.class);
                startActivity(intent);
            }
        });

        HouseDBHelper dbHelper =  new HouseDBHelper(this);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));
        houseModels = dbHelper.getAllHouse();

        //carRecyclerView.setHasFixedSize(true);
        houseAdapter =  new HouseAdapter(MainActivity.this, houseModels);
        carRecyclerView.setAdapter(houseAdapter);
    }
}