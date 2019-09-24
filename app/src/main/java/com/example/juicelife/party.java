package com.example.samplefirebase;

public class party {

    private String partyID;
    private String reserversName;
    private Integer reserversContactNo;
    private String requiredJuice;
    private Integer quantity;
    private String hall;

    public party() {
    }

    public String getPartyID() {
        return partyID;
    }

    public String getReserversName() {
        return reserversName;
    }

    public Integer getReserversContactNo() {
        return reserversContactNo;
    }

    public String getRequiredJuice() {
        return requiredJuice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    public void setReserversName(String reserversName) {
        this.reserversName = reserversName;
    }

    public void setReserversContactNo(Integer reserversContactNo) {
        this.reserversContactNo = reserversContactNo;
    }

    public void setRequiredJuice(String requiredJuice) {
        this.requiredJuice = requiredJuice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }
}
