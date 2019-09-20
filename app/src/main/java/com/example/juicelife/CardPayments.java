package com.example.juicelife;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class CardPayments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_payments);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (CardPayments.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);


        Spinner  mySpinner1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String>myAdapter1 = new ArrayAdapter<String>
                (CardPayments.this,android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.Year));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner1.setAdapter(myAdapter1);
    }
}
