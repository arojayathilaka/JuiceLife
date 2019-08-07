package com.example.juicelife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //radioGroup = findViewById(R.id.radioGrpDelTime);
    }

   /* public void checkButton(View view){
        Fragment fragment;
        /*int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);*/

        /*if(view == findViewById(R.id.delLate)){
            fragment = new deliveryTime();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragLater,fragment);
            ft.commit();
        }
    }*/

    public void onClickSaveDel(View view){
        startActivity(new Intent(MainActivity.this, delCity.class ));
    }
}
