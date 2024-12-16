package com.example.mandipriceapp;


public class Item {
    private String name;
    private double price;
    private int image;
    private int quantity;

    public Item(String name, double price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = 0;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getImage() { return image; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}