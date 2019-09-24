package com.example.juicelife;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

import static com.example.juicelife.DelCity.EXTRA_CHARGE;


public class DeliveryDetails extends AppCompatActivity{
    private static Button date, time;
    private static TextView set_date, set_time;
    private static final int Date_id = 0;
    private static final int Time_id = 1;

    EditText txtFName, txtLName, txtEmail, txtAddress, txtConNo;
    TextView txtDate, txtTime;
    Button btnAdd, btnCont, btnView, btnUpdate, btnCancel;
    Delivery del;
    DatabaseReference dbRef;
    long maxId = 0;
    long count = 0;

    //clear all inputs
    private void clearControls(){
        txtFName.setText("");
        txtLName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtConNo.setText("");
        txtDate.setText("");
        txtTime.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
        //radioGroup = findViewById(R.id.radioGrpDelTime);*/
        //dateText = findViewById(R.id.dateText);
        date = findViewById(R.id.pickDate);
        time = findViewById(R.id.pickTime);
        set_date = findViewById(R.id.dateText);
        set_time = findViewById(R.id.timeText);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Show Date dialog
                showDialog(Date_id);
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Show time dialog
                showDialog(Time_id);
            }
        });

        txtFName = findViewById(R.id.fname);
        txtLName = findViewById(R.id.lname);
        txtEmail = findViewById(R.id.email);
        txtAddress = findViewById(R.id.address);
        txtConNo = findViewById(R.id.conNo);
        txtDate = findViewById(R.id.dateText);
        txtTime = findViewById(R.id.timeText);
        btnCont = findViewById(R.id.BtnCont);
        btnAdd = findViewById(R.id.BtnAdd);
        btnView = findViewById(R.id.BtnView);
        btnUpdate = findViewById(R.id.BtnUpdate);
        btnCancel = findViewById(R.id.BtnCancel);

        del = new Delivery();

        dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxId = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(TextUtils.isEmpty(txtFName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter first name", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtLName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter last name", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtAddress.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter address", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtConNo.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter contact number", Toast.LENGTH_SHORT).show();
                    else {
                        //take inputs from the user and assigning them to this instance (del) of delivery
                        del.setFName(txtFName.getText().toString().trim());
                        del.setLName(txtLName.getText().toString().trim());
                        del.setAddress(txtAddress.getText().toString().trim());
                        del.setConNo(Integer.parseInt(txtConNo.getText().toString().trim()));
                        del.setEmail(txtEmail.getText().toString().trim());
                        del.setDate(txtDate.getText().toString());
                        del.setTime(txtTime.getText().toString());

                        //insert into the database
                        //dbRef.push().setValue(del);
                        dbRef.child("Del" + (maxId)).setValue(del);


                        //Feedback to the user via a toast
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }
                catch(NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("Del" + (maxId - 1));
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()) {
                            txtFName.setText(dataSnapshot.child("fname").getValue().toString());
                            txtLName.setText(dataSnapshot.child("lname").getValue().toString());
                            txtAddress.setText(dataSnapshot.child("address").getValue().toString());
                            txtConNo.setText(dataSnapshot.child("conNo").getValue().toString());
                            txtEmail.setText(dataSnapshot.child("email").getValue().toString());
                            txtDate.setText(dataSnapshot.child("date").getValue().toString());
                            txtTime.setText(dataSnapshot.child("time").getValue().toString());
                        }
                        else
                            Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
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
                DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Del" + (maxId - 1) )){
                            try {
                                del.setFName(txtFName.getText().toString().trim());
                                del.setLName(txtLName.getText().toString().trim());
                                del.setAddress(txtAddress.getText().toString().trim());
                                del.setConNo(Integer.parseInt(txtConNo.getText().toString().trim()));
                                del.setEmail(txtEmail.getText().toString().trim());
                                del.setDate(txtDate.getText().toString());
                                del.setTime(txtTime.getText().toString());

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("Del" + (maxId - 1) );
                                dbRef.setValue(del);
                                clearControls();
                                //Feedback to the user via a toast
                                Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                if (count == maxId)
                                    count--;
                            }
                            catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(), "No source to Update", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Del" + (maxId - 1))){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("Del" + (maxId - 1));
                            dbRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                            //count--;
                        }
                        else
                            Toast.makeText(getApplicationContext(), "No Source to Delete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (maxId > count){
                    String deliveryCharge = getIntent().getStringExtra(EXTRA_CHARGE);
                    Intent intent = new Intent(DeliveryDetails.this, Bill.class);
                    intent.putExtra(EXTRA_CHARGE, deliveryCharge);
                    startActivity(intent);
                    count = maxId;
                }
                else
                    Toast.makeText(getApplicationContext(), "Enter delivery details to continue", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        // Get the calender
        Calendar c = Calendar.getInstance();
        // From calender get the year, month, day, hour, minute
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        switch (id) {
            case Date_id:
                // Open the datepicker dialog
                return new DatePickerDialog(DeliveryDetails.this, date_listener, year,
                        month, day);
            case Time_id:
                // Open the timepicker dialog
                return new TimePickerDialog(DeliveryDetails.this, time_listener, hour,
                        minute, false);

        }
        return null;
    }

    // Date picker dialog
    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // store the data in one string and set it to text
            String date1 = month + "/" + day
                    + "/" + year;
            set_date.setText(date1);
        }
    };
    TimePickerDialog.OnTimeSetListener time_listener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            // store the data in one string and set it to text
            String time1 = hour + ":" + minute;
            set_time.setText(time1);
        }
    };
}
