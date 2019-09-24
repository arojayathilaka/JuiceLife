package com.example.juicelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Bill extends AppCompatActivity {
    TextView delCharge, txtPrice, txtTax, txtTotPrice, txtFName, txtLName, txtAddress, txtConNo;
    Button conDel, btnBack2;
    double delivery, price, tax, tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        getSupportActionBar().setTitle("Total bill");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*String fname = intent.getStringExtra(DeliveryDetails.EXTRA_FNAME);
        String lname = intent.getStringExtra(DeliveryDetails.EXTRA_LNAME);
        String address = intent.getStringExtra(DeliveryDetails.EXTRA_ADDRESS);
        String conNo = intent.getStringExtra(DeliveryDetails.EXTRA_CONTACTNO);

        txtFName = findViewById(R.id.fname);
        txtFName.setText(fname);

        txtLName = findViewById(R.id.lname);
        txtLName.setText(lname);

        txtAddress = findViewById(R.id.address);
        txtAddress.setText(address);

        txtConNo = findViewById(R.id.conNo);
        txtConNo.setText(conNo);*/

        Intent intent = getIntent();
        String deliveryCharge = intent.getStringExtra(DelCity.EXTRA_CHARGE);
        delCharge = findViewById(R.id.delCharge);
        delCharge.setText(deliveryCharge);
        delivery = Double.parseDouble(delCharge.getText().toString());

        txtPrice = findViewById(R.id.price);
        price = Double.parseDouble(txtPrice.getText().toString());

        txtTax = findViewById(R.id.tax);
        tax = Double.parseDouble(txtTax.getText().toString());

        txtTotPrice = findViewById(R.id.totPrice);
        //tot = Float.parseFloat(txtTotPrice.getText().toString());

        tot = price + tax + delivery;
        txtTotPrice.setText(String.valueOf(tot));

        /*conDel = findViewById(R.id.confirmDel);
        conDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();

            }
        });

        btnBack2 = findViewById(R.id.BtnBack2);
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bill.this, DeliveryDetails.class);
                startActivity(intent);

            }
        });*/
    }


}
