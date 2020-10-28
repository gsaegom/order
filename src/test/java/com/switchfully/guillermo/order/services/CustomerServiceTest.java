package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.Customer;
import com.switchfully.guillermo.order.repository.CustomerDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    @Test
    void givenNecessaryInformation_ICanCreateNewCustomerAccount() {
        CustomerDatabase customerDatabase = new CustomerDatabase();
        Customer customer = new Customer("John", "Doe", "john@doe.com", "123 Fake St.", "041304123");
        customerDatabase.addCustomerAccount(customer);
        Assertions.assertEquals(customerDatabase.getCustomerDatabase().get(customer.getId()), customer);
    }
}