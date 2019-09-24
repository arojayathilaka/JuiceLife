package com.example.samplefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class partyReservation extends AppCompatActivity {


    EditText txtID, txtReserversName, txtReserversContactNo, txtRequiredJuice, txtQuantity,txtHall;
    Button btnSave, btnShow, btnUpdate, btnDelete;
    DatabaseReference dbRef;
    party prty;

    private AwesomeValidation awesomeValidation;

    private void clearControls() {

        txtID.setText("");
        txtReserversName.setText("");
        txtReserversContactNo.setText("");
        txtRequiredJuice.setText("");
        txtQuantity.setText("");
        txtHall.setText("");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);


        txtID = findViewById(R.id.etID);
        txtReserversName = findViewById(R.id.etReserversName);
        txtReserversContactNo = findViewById(R.id.etContactNo);
        txtRequiredJuice = findViewById(R.id.etRequiredJuice);
        txtQuantity = findViewById(R.id.etQuantity);
        txtHall = findViewById(R.id.etHall);

        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        prty = new party();


        awesomeValidation.addValidation(this, R.id.etReserversName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.reservationNameError);
        awesomeValidation.addValidation(this, R.id.etContactNo, "^[0]{1}[0-9]{9}$", R.string.contactNumberError);
        awesomeValidation.addValidation(this, R.id.etQuantity, Range.closed(1, 25), R.string.QuantityError);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (awesomeValidation.validate()) {
                    dbRef = FirebaseDatabase.getInstance().getReference().child("party");


                    prty.setPartyID(txtID.getText().toString().trim());
                    prty.setReserversName(txtReserversName.getText().toString().trim());
                    prty.setReserversContactNo(Integer.parseInt(txtReserversContactNo.getText().toString().trim()));
                    prty.setRequiredJuice(txtRequiredJuice.getText().toString().trim());
                    prty.setQuantity(Integer.parseInt(txtQuantity.getText().toString().trim()));
                    prty.setHall(txtHall.getText().toString().trim());


                    // dbRef.push().setValue(prty);
                    dbRef.child("IT001").setValue(prty);

                    Toast.makeText(getApplicationContext(), "added successfully!", Toast.LENGTH_LONG).show();

                    clearControls();

                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef=FirebaseDatabase.getInstance().getReference().child("party").child("IT001");

                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange( @NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){

                            txtID.setText(dataSnapshot.child("partyID").getValue().toString());
                            txtReserversName.setText(dataSnapshot.child("reserversName").getValue().toString());
                            txtReserversContactNo.setText(dataSnapshot.child("reserversContactNo").getValue().toString());
                            txtRequiredJuice.setText(dataSnapshot.child("requiredJuice").getValue().toString());
                            txtQuantity.setText(dataSnapshot.child("quantity").getValue().toString());
                            txtHall.setText(dataSnapshot.child("hall").getValue().toString());

                        }else{

                            Toast.makeText(getApplicationContext(),"No values to display",Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled( @NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {

                if (awesomeValidation.validate()) {
                    dbRef = FirebaseDatabase.getInstance().getReference().child("party");

                    dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.hasChild("IT001")) {

                                prty.setPartyID(txtID.getText().toString().trim());
                                prty.setReserversName(txtReserversName.getText().toString().trim());
                                prty.setReserversContactNo(Integer.parseInt(txtReserversContactNo.getText().toString().trim()));
                                prty.setRequiredJuice(txtRequiredJuice.getText().toString().trim());
                                prty.setQuantity(Integer.parseInt(txtQuantity.getText().toString().trim()));
                                prty.setHall(txtHall.getText().toString().trim());


//                            dbref = FirebaseDatabase.getInstance().getReference().child("student").child("IT001");
                                dbRef = dbRef.child("IT001");
                                dbRef.setValue(prty);


                                Toast.makeText(getApplicationContext(), "update succcessful", Toast.LENGTH_SHORT).show();
                                clearControls();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("party");

                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("IT001")){

                            dbRef = FirebaseDatabase.getInstance().getReference().child("party").child("IT001");
                            dbRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_SHORT).show();


                        }else{

                            Toast.makeText(getApplicationContext(),"No sourse for delete",Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });



    }

    public void OnClickbtnHallIntent(View view){
        startActivity(new Intent(partyReservation.this,HallDetails.class));
    }


}
