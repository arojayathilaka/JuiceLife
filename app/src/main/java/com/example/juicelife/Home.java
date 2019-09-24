package com.example.juicelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickJuice(View v){
        startActivity(new Intent(Home.this,Juice.class));
    }

    public void OnClickDessert(View v){
        startActivity(new Intent(Home.this,Dessert.class));
    }

    public void OnClickMocktails(View v){
        startActivity(new Intent(Home.this,Mocktails.class));
    }

    public void OnClickSmoothies(View v){
        startActivity(new Intent(Home.this,Smoothies.class));
    }

}
