package com.example.juicelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class delCity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_city);

        getSupportActionBar().setTitle("Add your city");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinner = (Spinner) findViewById(R.id.selectCity);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(delCity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cities));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
    }

    public void onClickSaveDel(View view){
        startActivity(new Intent(delCity.this, ConfirmDelivery.class ));
    }


}
