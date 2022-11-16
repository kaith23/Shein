package com.accenture.ws.controller;
import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.impl.DiscountedBill;
import com.accenture.ws.impl.RegularBill;
import com.accenture.ws.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:4200")
public class OrderAndBillingController {
    private final OrderRepository orderRepository;
    private final RegularBill regularBill;
    private final DiscountedBill discountedBill;
    @Autowired
    public OrderAndBillingController(OrderRepository orderRepository,
                                     RegularBill regularBill, DiscountedBill discountedBill) {
        this.orderRepository = orderRepository;
        this.regularBill = regularBill;
        this.discountedBill = discountedBill;
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrderList(){
        return orderRepository.findAll();
    }
    @GetMapping("all/regularTotalPrice")
    @ResponseStatus(HttpStatus.OK)
    public OrderBill getRegularTotalPrice(){
        List<Order> totalPrice = orderRepository.findAll();
        regularBill.setOrderList(totalPrice);
        return regularBill;
    }
    @GetMapping("all/discountedTotalPrice")
    @ResponseStatus(HttpStatus.OK)
    public OrderBill getDiscountedTotalPrice(){
        List<Order> totalPrice = orderRepository.findAll();
        discountedBill.setOrderList(totalPrice);
        return discountedBill;
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable("id") Order id){
        orderRepository.delete(id);
    }
    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.OK)
    public String deleteOrder(){
        orderRepository.deleteAll();
        return "All Items are deleted";
    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@RequestBody Order newOrder, @PathVariable Long id) {
        return orderRepository.findOrderById(id)
                .map(order-> {
                    order.setOrderName(newOrder.getOrderName());
                    order.setPrice(newOrder.getPrice());
                    order.setDiscounted(newOrder.isDiscounted());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return orderRepository.save(newOrder);
                });
    }
}