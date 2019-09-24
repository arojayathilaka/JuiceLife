package com.example.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Juice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice);

        getSupportActionBar().setTitle("Juices");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.mangojuice, 250, "Mango Juice (250 LKR)"));
        items.add(new Item(R.drawable.papaya, 300, "Papaya Juice (300 LKR)"));
        items.add(new Item(R.drawable.passionfruit, 350, "Passion-Fruit Juice (350 LKR)"));
        ItemAdapter adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }


    public void onClickcart(View v){
        startActivity(new Intent(Juice.this, CartActivity.class));
    }
}
