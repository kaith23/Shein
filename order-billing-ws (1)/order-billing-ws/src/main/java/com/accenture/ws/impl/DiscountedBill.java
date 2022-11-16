package com.accenture.ws.impl;

import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
public class DiscountedBill extends OrderBill {

    public DiscountedBill() {
    }
    @Override
    public double getTotalBill() {
        double totalBill = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");
        List<Order> orderList = getOrderList();
        for (Order items :orderList) {
            if (!items.isDiscounted()) {
                totalBill = items.getPrice() + totalBill;
            } else {
                totalBill = (items.getPrice() - (items.getPrice()* (items.getIsDiscountedPercentage()/100)) ) + totalBill;
            }
        }
        return Double.parseDouble(df.format(totalBill));
    }

    public void setOrderList(List<Order> totalPrice) {
    }
}