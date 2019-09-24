package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Mocktails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocktails);

        getSupportActionBar().setTitle("Mocktails");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.coconutmocktail, 200, "Coconut Mocktails(200 LKR)"));
        items.add(new Item(R.drawable.strawberrymocktail, 550, "Strawberry Mocktails(550 LKR)"));
        items.add(new Item(R.drawable.mangomocktail, 360, "Mango Mocktails(360 LKR)"));
        ItemAdapter adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }


    public void onClickcart(View v){
        startActivity(new Intent(Mocktails.this, CartActivity.class));
    }
}
