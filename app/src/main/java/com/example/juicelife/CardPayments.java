package com.example.payment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.juicelife.CardPay;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;



public class CardPayments extends AppCompatActivity {
    EditText txtName, txtId, txtCvc;
    Button btnSave, btnShow, btnUpdate, btnDelete;
    Spinner spinYear,spinMonth;
    DatabaseReference dbRef;
    CardPay card;
    private AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_payments);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        spinMonth= (Spinner)findViewById(R.id.spnMonth);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (CardPayments.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinMonth.setAdapter(myAdapter);


        spinYear=(Spinner)findViewById(R.id.spnYear);
        ArrayAdapter<String>myAdapter1 = new ArrayAdapter<String>
                (CardPayments.this,android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.Year));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinYear.setAdapter(myAdapter1);


        txtName = findViewById(R.id.spaceForName);
        txtId = findViewById(R.id.spaceForNo);
        txtCvc = findViewById(R.id.cvcSpace);

        btnSave = findViewById(R.id.Bsave);
        btnShow = findViewById(R.id.Bshow);
        btnUpdate = findViewById(R.id.bUpdate);
        btnDelete = findViewById(R.id.bDelete);

        awesomeValidation.addValidation(this, R.id.spaceForName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.spaceForNo, "\\b\\d{4}(| |-)\\d{4}\\1\\d{4}\\1\\d{4}\\b", R.string.iderror);
        awesomeValidation.addValidation(this, R.id.cvcSpace, "^[0-9]{3}$", R.string.cvcerror);


        card = new CardPay();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {
                    dbRef = FirebaseDatabase.getInstance().getReference().child("CardPay");

                    card.setCardName(txtName.getText().toString().trim());
                    card.setCardId(txtId.getText().toString().trim());
                    card.setCardYear(Integer.parseInt(spinYear.getSelectedItem().toString().trim()));
                    card.setCardMonth(spinMonth.getSelectedItem().toString().trim());
                    card.setCardCvc(Integer.parseInt(txtCvc.getText().toString().trim()));
                    //dbRef.push().setValue(std);
                    dbRef.child("card1").setValue(card);
                    Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                    clearControls();
                }
            }

        });


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("CardPay").child("card1");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            txtId.setText(dataSnapshot.child("cardName").getValue().toString());
                            txtName.setText(dataSnapshot.child("cardId").getValue().toString());
                            spinYear.setPrompt(dataSnapshot.child("cardYear").getValue().toString());
                            spinMonth.setPrompt(dataSnapshot.child("cardMonth").getValue().toString());
                            txtCvc.setText(dataSnapshot.child("cardCvc").getValue().toString());
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Display",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (awesomeValidation.validate()) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("CardPay");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("card1")) {
                            try {
                                card.setCardName(txtId.getText().toString().trim());
                                card.setCardId(txtName.getText().toString().trim());
                                card.setCardMonth(spinMonth.getSelectedItem().toString().trim());
                                card.setCardYear(Integer.parseInt(spinYear.getSelectedItem().toString().trim()));
                                card.setCardCvc(Integer.parseInt(txtCvc.getText().toString().trim()));

                                dbRef = FirebaseDatabase.getInstance().getReference().child("CardPay").child("card1");
                                dbRef.setValue(card);
                                clearControls();

                                Toast.makeText(getApplicationContext(), "Data Updated successfully", Toast.LENGTH_SHORT).show();
                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid CVC Number", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "No Source to update", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            //}
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("CardPay");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("card1")){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("CardPay").child("card1");
                            dbRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Data deleted Successfully",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No source to Delete",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
    private void clearControls(){

        txtName.setText("");
        //spinMonth.setPrompt("January");
        //spinYear.setPrompt("2019");
        txtId.setText("");
        txtCvc.setText("");

    }
}
