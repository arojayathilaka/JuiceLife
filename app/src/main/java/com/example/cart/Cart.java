package com.example.cart;

public class Cart {
    private String item_name, quantity, total_price;

    public Cart() {
    }

    public Cart(String item_name, String quantity, String total_price) {
        this.item_name = item_name;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }
}
