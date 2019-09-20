package com.example.juicelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Juice extends AppCompatActivity {
    TextView number1;
    TextView number2;
    TextView number3;
    Button btnIncrement;
    Button btnDecrement;

    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice);

        getSupportActionBar().setTitle("Juices");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        number1 = findViewById(R.id.number1);
        btnIncrement = findViewById(R.id.btnIncrement1);
        btnDecrement = findViewById(R.id.btnDecrement1);

        //show zero on launch
        number1.setText("0");

        btnIncrement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter1 = counter1 + 1;
                number1.setText(String.valueOf(counter1));
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1 = counter1 - 1;
                number1.setText(String.valueOf(counter1));
            }
        });

        number2 = findViewById(R.id.number2);
        btnIncrement = findViewById(R.id.btnIncrement2);
        btnDecrement = findViewById(R.id.btnDecrement2);

        //show zero on launch
        number2.setText("0");

        btnIncrement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter2 = counter2 + 1;
                number2.setText(String.valueOf(counter2));
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2 = counter2 - 1;
                number2.setText(String.valueOf(counter2));
            }
        });

        number3 = findViewById(R.id.number3);
        btnIncrement = findViewById(R.id.btnIncrement3);
        btnDecrement = findViewById(R.id.btnDecrement3);

        //show zero on launch
        number3.setText("0");

        btnIncrement.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        counter3 = counter3 + 1;
                        number3.setText(String.valueOf(counter3));
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter3 = counter3 - 1;
                number3.setText(String.valueOf(counter3));
            }
        });
    }

    public void onClickcart(View v){
        startActivity(new Intent(Juice.this,Cart.class));
    }
}
