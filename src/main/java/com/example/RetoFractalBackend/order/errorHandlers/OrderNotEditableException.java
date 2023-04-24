package com.example.RetoFractalBackend.order.errorHandlers;

public class OrderNotEditableException extends RuntimeException {
    public OrderNotEditableException (Long id) {
        super ("Cannot edit COMPLETED order " + id);
    }
}
