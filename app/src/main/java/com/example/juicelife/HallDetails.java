package com.example.samplefirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HallDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_details);
    }

    public void OnClickbtnGoBack(View view){

        startActivity(new Intent(HallDetails.this,MainActivity.class));
    }
}
