package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Order;
import com.switchfully.guillermo.order.domain.users.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderDatabase {
    private Map<UUID, List<Order>> orderDatabase;
    private UserDatabase userDatabase;

    public OrderDatabase(UserDatabase userDatabase) {
        this.orderDatabase = new HashMap<>();
        this.userDatabase = userDatabase;
    }

    public void addOrder(UUID customerId, Order order) {
        if (orderDatabase.containsKey(customerId)) {
            orderDatabase.get(customerId).add(order);
        } else {
            if (userDatabase.getUserType(customerId) == Customer.class) {
                List<Order> orderList = new ArrayList<>();
                orderList.add(order);
                orderDatabase.put(customerId, orderList);
            }
        }
    }
}
