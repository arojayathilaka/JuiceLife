package com.example.juicelife;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    /*
    EditText time;
     RadioGroup radioGroup;
     RadioButton radioButton;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //radioGroup = findViewById(R.id.radioGrpDelTime);
    }

    public void changeFragment(View view){
        Fragment fragment;
        //int radioId = radioGroup.getCheckedRadioButtonId();
        //radioButton = findViewById(radioId);

        if(view == findViewById(R.id.delLate))
            fragment = new deliveryTime();
        else
            fragment = new deliverNow();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragDelTime, fragment);
        ft.commit();

    }

    public void onClickSaveDel(View view){
        startActivity(new Intent(MainActivity.this, delCity.class ));
    }
}
