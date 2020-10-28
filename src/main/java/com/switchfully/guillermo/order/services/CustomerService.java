package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.Customer;
import com.switchfully.guillermo.order.repository.UserDatabase;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    private UserDatabase userDatabase;

    public CustomerService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public void createCustomerAccount(Customer customer) {

        userDatabase.addCustomerAccount(customer);
    }
}
