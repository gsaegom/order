package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.Stock;
import com.switchfully.guillermo.order.exceptions.AdminPrivilegeException;
import com.switchfully.guillermo.order.domain.users.Admin;
import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.repository.ItemDatabase;
import com.switchfully.guillermo.order.repository.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ItemService {
    private final ItemDatabase itemDatabase;
    private final UserDatabase userDatabase;
    private final ValidationService validationService;

    @Autowired
    public ItemService(ItemDatabase itemDatabase, UserDatabase userDatabase, ValidationService validationService) {
        this.itemDatabase = itemDatabase;
        this.userDatabase = userDatabase;
        this.validationService = validationService;
    }

    public void addItem(Item item, UUID userId) {
        adminCheck(userId);
        setStockLevel(item);
        itemDatabase.addItem(item);
    }


    public List<Item> getAllItems(UUID userId) {
        adminCheck(userId);
        return itemDatabase.getAllItems();
    }

    public List<Item> getItemsByStockLevel(Stock stockLevel, UUID userId) {
        adminCheck(userId);
        return itemDatabase.getItemsByStockLevel(stockLevel);
    }

    public void setStockLevel(Item item) {
        if (item.getAmount() < 5) {
            item.setStockLevel(Stock.LOW);
        } else if (item.getAmount() < 10) {
            item.setStockLevel(Stock.MEDIUM);
        } else {
            item.setStockLevel(Stock.HIGH);
        }
    }

    private void adminCheck(UUID userId) {
        if (!validationService.isValidUUID(userId.toString()) || !userDatabase.userExists(userId))
            throw new IllegalArgumentException("Invalid ID.");
        if (userDatabase.getUserType(userId) != Admin.class) {
            throw new AdminPrivilegeException("Only admins can perform this action.");
        }
    }
}
