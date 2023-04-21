package com.example.RetoFractalBackend.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Float unitPrice;
    private Long stock;
    private Float totalPrice;

    protected Product () {}

    public Product (String name, Float unitPrice, Long stock, Float totalPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.totalPrice = totalPrice;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long newId) {
        id = newId;
    }

    public String getName () {
        return name;
    }

    public void setName (String newName) {
        name = newName;
    }

    public Float getUnitPrice () {
        return unitPrice;
    }

    public void setUnitPrice (Float newUnitPrice) {
        unitPrice = newUnitPrice;
    }

    public Long getStock () {
        return stock;
    }

    public void setStock (Long newStock) {
        stock = newStock;
    }

    public Float getTotalPrice () {
        return totalPrice;
    }

    public void setTotalPrice (Float newTotalPrice) {
        totalPrice = newTotalPrice;
    }
}
