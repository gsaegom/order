package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.api.dtos.ItemDTO;
import com.switchfully.guillermo.order.domain.Admin;
import com.switchfully.guillermo.order.domain.Customer;
import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.exceptions.AdminPrivilegeException;
import com.switchfully.guillermo.order.repository.ItemDatabase;
import com.switchfully.guillermo.order.repository.UserDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {
    @Test
    void givenNecessaryInformation_AnAdminCanAddItem() {
        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemService itemService = new ItemService(itemDatabase,userDatabase,new ValidationService());
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"), "JoeTheAdmin", "Doe", "joe@theadmin.com");
        userDatabase.addAdmin(admin);
        Item item = new Item("Pencil", "Use it to write or draw stuff.", 1.20, 100);
        itemService.addItem(item,admin.getId());
        Assertions.assertEquals(itemDatabase.getItem(item.getId()),item);
    }

    @Test
    void ifNonAdminTriesToAddItem_ThrowsAdminPrivilegeException() {
        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemService itemService = new ItemService(itemDatabase,userDatabase,new ValidationService());
        Customer notAnAdmin = new Customer(UUID.fromString("1f8767ee-e926-4b5a-bcdd-cb6aa3c04c21"), "Smith", "Jane", "jane@smith.com", "50 Nice St", "020394823049");
        userDatabase.addCustomerAccount(notAnAdmin);
        Item item = new Item("Pencil", "Use it to write or draw stuff.", 1.20, 100);
        Assertions.assertThrows(AdminPrivilegeException.class,()->itemService.addItem(item,notAnAdmin.getId()));
    }
}