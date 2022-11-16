package com.accenture.ws.services;

import com.accenture.ws.entity.Order;
import com.accenture.ws.exception.OrderException;
import com.accenture.ws.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderAndBillService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderAndBillService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order addOrder(Order order) {
        order.setOrderName(UUID.randomUUID().toString());
        return orderRepository.save(order);
    }
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id)
                .orElseThrow(() -> new OrderException("User by id " + id + " was not found"));
    }
    public void deleteOrder(Long id) {
        orderRepository.deleteOrderById(id);
    }
}