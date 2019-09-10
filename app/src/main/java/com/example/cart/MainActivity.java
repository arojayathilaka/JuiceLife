package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickJuice(View v){
        startActivity(new Intent(MainActivity.this,Juice.class));
    }

    public void OnClickDessert(View v){
        startActivity(new Intent(MainActivity.this,Dessert.class));
    }

    public void OnClickMocktails(View v){
        startActivity(new Intent(MainActivity.this,Mocktails.class));
    }

    public void OnClickSmoothies(View v){
        startActivity(new Intent(MainActivity.this,Smoothies.class));
    }

}
