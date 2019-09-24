package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Smoothies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoothies);

        getSupportActionBar().setTitle("Smoothies");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.raspberrysmoothie, 620, "Raspberry Smoothie (620 LKR)"));
        items.add(new Item(R.drawable.pineapplesmoothie, 530, "Pineapple Smoothie (530 LKR)"));
        items.add(new Item(R.drawable.raspberrysmoothie, 500, "Apple Smoothie (500 LKR)"));
        ItemAdapter adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }


    public void onClickcart(View v){
        startActivity(new Intent(Smoothies.this, CartActivity.class));
    }
}
