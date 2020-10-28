package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class CustomerDatabase {
    Map<UUID, Customer> customerDatabase;

    public CustomerDatabase() {
        this.customerDatabase = new HashMap<>();
    }

    public Map<UUID, Customer> getCustomerDatabase() {
        return customerDatabase;
    }

    public Customer addCustomerAccount(Customer customer) {
        customerDatabase.put(customer.getId(), customer);
        return (Customer) customerDatabase.get(customer.getId());

    }
}
