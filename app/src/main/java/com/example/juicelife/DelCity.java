package com.example.juicelife;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DelCity extends AppCompatActivity {
    public static final String EXTRA_CHARGE = "com.example.juiceLife.CHARGE";
    Spinner spinner;
    TextView delCharge;
    Button btnCont, btnBack;
    String delChar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_city);

        getSupportActionBar().setTitle("Select your city");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner = findViewById(R.id.selectCity);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(
                DelCity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.cities));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                delCharge = findViewById(R.id.delCharge);
                if(i == 0) {
                    double del = 90.15;
                    delChar = String.valueOf(del);
                    delCharge.setText(delChar);
                }
                else if(i == 1) {
                    double del = 100.45;
                    delChar = String.valueOf(del);
                    delCharge.setText(delChar);
                }
                else if(i == 2) {
                    double del = 110.30;
                    delChar = String.valueOf(del);
                    delCharge.setText(delChar);
                }
                else{
                    double del = 120.75;
                    delChar = String.valueOf(del);
                    delCharge.setText(delChar);
                }
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " selected", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        btnCont = findViewById(R.id.BtnCont);
        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(DelCity.this);
                alert.setTitle("Your Delivery Charge is Rs. " + delChar);
                alert.setMessage("Do you wish to continue?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(DelCity.this, DeliveryDetails.class );
                        String deliveryCharge = delCharge.getText().toString();
                        intent.putExtra(EXTRA_CHARGE, deliveryCharge);
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.create().show();
            }
        });

        /*btnBack = findViewById(R.id.BtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DelCity.this, DeliveryDetails.class);
                startActivity(intent);
            }
        });*/

    }

}
