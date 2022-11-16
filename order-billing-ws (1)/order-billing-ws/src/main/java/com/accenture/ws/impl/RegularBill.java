package com.accenture.ws.impl;
import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;
import org.springframework.stereotype.Component;
import java.text.DecimalFormat;
import java.util.List;
@Component
public class RegularBill extends OrderBill {
    public RegularBill() {
    }
    @Override
    public double getTotalBill() {
        DecimalFormat df = new DecimalFormat("#.##");
        double totalBill = 0.0;
        List<Order> orderList = getOrderList();
        for (Order list :orderList) {
            totalBill = list.getPrice() + totalBill;
        }
        return Double.parseDouble(df.format(totalBill));
    }
}