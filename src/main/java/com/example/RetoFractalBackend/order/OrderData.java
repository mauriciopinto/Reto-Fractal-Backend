package com.example.RetoFractalBackend.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderNumber;
    private String date;
    private Long numberOfProducts;
    private Float finalPrice;

    protected OrderData () {}

    public OrderData (Long orderNumber, String date, Long numberOfProducts, Float finalPrice) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.numberOfProducts = numberOfProducts;
        this.finalPrice = finalPrice;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long newId) {
        id = newId;
    }

    public Long getOrderNumber () {
        return orderNumber;
    }

    public void setOrderNumber (Long newOrderNumber) {
        orderNumber = newOrderNumber;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String newDate) {
        date = newDate;
    }

    public Long getNumberOfProducts () {
        return numberOfProducts;
    }

    public void setNumberOfProducs (Long newNumberOfProducts) {
        numberOfProducts = newNumberOfProducts;
    }

    public Float getFinalPrice () {
        return finalPrice;
    }

    public void setFinalPrice (Float newFinalPrice) {
        finalPrice = newFinalPrice;
    }
}