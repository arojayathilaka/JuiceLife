package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class PaymentMethod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
    }


    public void OnClickCash(View v){
        startActivity(new Intent(PaymentMethod.this, CashOnDelivery.class));
    }
    public void OnClickCard(View v){
        startActivity(new Intent(PaymentMethod.this, CardPayments.class));
    }
}
