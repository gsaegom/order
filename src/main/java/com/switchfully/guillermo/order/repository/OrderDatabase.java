package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.domain.ItemGroup;
import com.switchfully.guillermo.order.domain.Order;
import com.switchfully.guillermo.order.domain.users.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Repository
public class OrderDatabase {
    private Map<UUID, List<Order>> orderDatabase;
    private UserDatabase userDatabase;
    private ItemDatabase itemDatabase;

    public OrderDatabase(UserDatabase userDatabase, ItemDatabase itemDatabase) {
        this.orderDatabase = new HashMap<>();
        this.userDatabase = userDatabase;
        this.itemDatabase = itemDatabase;
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
