package com.accenture.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;


@Entity
@Table(name = "order_table")

public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)

    private Long id;

    private String orderName;

    private double price;

    private boolean isDiscounted;

    @Transient
    private final double isDiscountedPercentage= 5.0;

    public Order(){

    }

    public Order(Long id, String orderName, double price, boolean isDiscounted) {
        this.id = id;
        this.orderName = orderName;
        this.price = price;
        this.isDiscounted = isDiscounted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }


    @JsonIgnore
    public double getIsDiscountedPercentage() {
        return isDiscountedPercentage;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", price=" + price +
                ", isDiscounted=" + isDiscounted +
                ", isDiscountedPercentage=" + isDiscountedPercentage +
                '}';
    }
}