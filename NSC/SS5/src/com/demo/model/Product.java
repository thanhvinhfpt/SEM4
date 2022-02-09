package com.demo.model;

public class Product {

    private String name;
    private int price;
    private int quantity;
    private int categoryID;

    public Product() {
    }

    public Product(String name, int price, int quantity, int categoryID) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
