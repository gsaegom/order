package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.Order;
import com.switchfully.guillermo.order.repository.OrderDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderService {
    private final OrderDatabase orderDatabase;

    @Autowired
    public OrderService(OrderDatabase orderDatabase) {
        this.orderDatabase = orderDatabase;
    }

    public void makeOrder(UUID customerId, Order order){
    orderDatabase.addOrder(customerId,order);
    }
}
