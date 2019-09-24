package com.example.juicelife;



public class Delivery {
    private String fName;
    private String lName;
    private String email;
    private String address;
    private int conNo;
    private String date;

    public int getConNo() {
        return conNo;
    }

    public void setConNo(int conNo) {
        this.conNo = conNo;
    }

    private String time;

    public Delivery() {
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fname) {
        this.fName = fname;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lname) {
        this.lName = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
