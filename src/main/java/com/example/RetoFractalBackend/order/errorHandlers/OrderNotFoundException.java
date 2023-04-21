package com.example.RetoFractalBackend.order.errorHandlers;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException (Long id) {
        super ("Could not find order of id: " + id);
    }
}