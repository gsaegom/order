package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.exceptions.AdminPrivilegeException;
import com.switchfully.guillermo.order.domain.Admin;
import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.repository.ItemDatabase;
import com.switchfully.guillermo.order.repository.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        if (!validationService.isValidUUID(userId.toString()))
            throw new IllegalArgumentException("The provided id is not valid!");
        if ((userDatabase.userExists(userId)) && (userDatabase.getUserType(userId) != Admin.class)) {
            throw new AdminPrivilegeException("Only admins can add items.");
        }
        itemDatabase.addItem(item);
    }
}
