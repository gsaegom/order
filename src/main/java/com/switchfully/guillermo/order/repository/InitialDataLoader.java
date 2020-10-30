package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.domain.Stock;
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
        Item item = new Item(UUID.fromString("b3abae44-16b4-4c94-b9a5-70939ba725e9"), "Computer", "A computer.", 99.99, 50, Stock.HIGH);
        Item item2 = new Item(UUID.fromString("55c8f980-62c4-4c3d-89ef-a8093a6a184b"), "rubber", "Use it to erase stuff.", 0.60, 9, Stock.MEDIUM);
        this.itemDatabase.addItem(item);
        this.itemDatabase.addItem(item2);
        this.userDatabase.addAdmin(admin);
        this.userDatabase.addCustomerAccount(customer);
    }
}
