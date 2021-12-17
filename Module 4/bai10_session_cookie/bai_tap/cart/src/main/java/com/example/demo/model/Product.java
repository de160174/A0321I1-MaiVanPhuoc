package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private String productId;

    private String productName;

    private double priceOld;

    private double priceNew;

    private String description;

    private String image;

    public Product() {
    }

    public Product(String productId, String productName, double priceOld, double priceNew, String description, String image) {
        this.productId = productId;
        this.productName = productName;
        this.priceOld = priceOld;
        this.priceNew = priceNew;
        this.description = description;
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(double priceOld) {
        this.priceOld = priceOld;
    }

    public double getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(double priceNew) {
        this.priceNew = priceNew;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
