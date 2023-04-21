package com.example.RetoFractalBackend.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderData, Long> {
    OrderData findById (long id);
}
