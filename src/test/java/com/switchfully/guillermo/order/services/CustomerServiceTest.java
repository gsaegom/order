package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.Customer;
import com.switchfully.guillermo.order.repository.UserDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerServiceTest {
    @Test
    void givenNecessaryInformation_ICanCreateNewCustomerAccount() {
        UserDatabase userDatabase = new UserDatabase();
        Customer customer = new Customer("John", "Doe", "john@doe.com", "123 Fake St.", "041304123");
        userDatabase.addCustomerAccount(customer);
        Assertions.assertEquals(userDatabase.getUser(customer.getId()),customer);
    }
}