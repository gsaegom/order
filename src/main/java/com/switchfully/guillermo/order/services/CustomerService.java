package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.Customer;
import com.switchfully.guillermo.order.repository.CustomerDatabase;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerService {

    private CustomerDatabase customerDatabase;

    public CustomerService(CustomerDatabase customerDatabase) {
        this.customerDatabase = customerDatabase;
    }

    public Customer createCustomerAccount(Customer customer) {

        return customerDatabase.addCustomerAccount(customer);
    }
}
