package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Order;
import com.switchfully.guillermo.order.domain.users.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderDatabase {
    private Map<Customer, List<Order>> orderDatabase;
    private UserDatabase userDatabase;

    public OrderDatabase() {
        this.orderDatabase = new HashMap<>();
    }

    public void addOrder(UUID customerId, Order order) {
        if (orderDatabase.containsKey(customerId)) {
            orderDatabase.get(userDatabase.getUser(customerId)).add(order);
        } else {
            if (userDatabase.getUserType(customerId) == Customer.class) {
                orderDatabase.put((Customer) userDatabase.getUser(customerId), new ArrayList<>(Arrays.asList(order)));
            }
        }
    }
}
