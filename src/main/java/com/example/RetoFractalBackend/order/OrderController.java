package com.example.RetoFractalBackend.order;

import java.util.List;

import com.example.RetoFractalBackend.order.errorHandlers.OrderNotEditableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RetoFractalBackend.order.errorHandlers.OrderNotFoundException;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin (origins = "http://34.95.219.44:3000")
@RestController
public class OrderController {
    private final OrderRepository repository;

    OrderController (OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping ("/orders")
    List<OrderData> all () {
        return repository.findAll();
    }

    @PostMapping ("/orders")
    OrderData newOrder (@RequestBody OrderData newOrder) {
        return repository.save(newOrder);
    }

    @GetMapping ("/orders/{id}")
    OrderData one (@PathVariable Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new OrderNotFoundException (id));
    }

    @PutMapping ("/orders/{id}")
    OrderData replaceOrder (@RequestBody OrderData newOrder, @PathVariable Long id) {
        if (newOrder.getStatus() == "COMPLETED") throw new OrderNotEditableException (id);

        return repository.findById(id).map(order -> {
            order.setOrderNumber(newOrder.getOrderNumber());
            order.setDate(newOrder.getDate());
            order.setNumberOfProducs(newOrder.getNumberOfProducts());
            order.setFinalPrice(newOrder.getFinalPrice());
            order.setStatus(newOrder.getStatus());
            return repository.save(order);
        })
        .orElseGet(() -> {
            newOrder.setId (id);
            return repository.save (newOrder);
        });
    }

    @DeleteMapping ("/orders/{id}")
    void deleteOrder (@PathVariable Long id) {
        repository.deleteById (id);
    }
}
