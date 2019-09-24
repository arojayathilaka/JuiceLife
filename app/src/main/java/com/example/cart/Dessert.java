package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Dessert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

        getSupportActionBar().setTitle("Dessert");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.bananaboat, 350, "Banana Boat (350 LKR)"));
        items.add(new Item(R.drawable.brownie, 350, "Brownie (350 LKR)"));
        items.add(new Item(R.drawable.chocolatepie, 420, "Chocolate Pie (420 LKR)"));
        ItemAdapter adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }


    public void onClickcart(View v){
        startActivity(new Intent(Dessert.this, CartActivity.class));
    }
}
