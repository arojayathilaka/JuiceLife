package com.example.juicelife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmDelivery extends AppCompatActivity {
    protected Button myButton;
    String myString = "Thank You!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_delivery);
        getSupportActionBar().setTitle("Add your city");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myButton = (Button)findViewById(R.id.confirmDel);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_SHORT).show();

            }
        });
    }


}
