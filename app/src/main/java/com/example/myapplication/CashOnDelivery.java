package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CashOnDelivery extends AppCompatActivity {

    protected Button myButton;
    String myString = "Thank you!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_on_delivery);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myButton = (Button)findViewById(R.id.CashOnDelivery);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),myString,Toast.LENGTH_LONG).show();
            }
        });


    }


}
