package com.accenture.ws.repository;

import com.accenture.ws.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    void deleteOrderById(Long id);

    Order findTopByOrderByIdDesc();

    Optional<Order> findOrderById(Long id);

}