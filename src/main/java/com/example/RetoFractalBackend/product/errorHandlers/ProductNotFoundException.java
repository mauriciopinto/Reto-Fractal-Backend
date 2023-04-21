package com.example.RetoFractalBackend.product.errorHandlers;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException (Long id) {
        super ("Could not find product with id: " + id);
    }
}
