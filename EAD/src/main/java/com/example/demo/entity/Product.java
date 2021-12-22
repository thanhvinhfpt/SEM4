package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String productName;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "date_of_manf")
    private String dateOfManf;

    @OneToMany(mappedBy = "product")
    private List<Sale> sales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfManf() {
        return dateOfManf;
    }

    public void setDateOfManf(String dateOfManf) {
        this.dateOfManf = dateOfManf;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}

