package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.users.Admin;
import com.switchfully.guillermo.order.domain.users.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitialDataLoader {
    ItemDatabase itemDatabase;
    UserDatabase userDatabase;

    @Autowired
    public InitialDataLoader(ItemDatabase itemDatabase, UserDatabase userDatabase) {
        this.itemDatabase = itemDatabase;
        this.userDatabase = userDatabase;

        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"), "JoeTheAdmin", "Doe", "joe@theadmin.com");
        Customer customer = new Customer(UUID.fromString("1f8767ee-e926-4b5a-bcdd-cb6aa3c04c21"), "Smith", "Jane", "jane@smith.com", "50 Nice St", "020394823049");
        this.userDatabase.addAdmin(admin);
        this.userDatabase.addCustomerAccount(customer);
    }
}
