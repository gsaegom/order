package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.domain.ItemGroup;
import com.switchfully.guillermo.order.repository.ItemDatabase;
import com.switchfully.guillermo.order.repository.ItemGroupDatabase;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Component
public class ItemGroupService {
    private ItemGroupDatabase itemGroupDatabase;
    private ItemDatabase itemDatabase;
    private ValidationService validationService;

    public ItemGroupService(ItemGroupDatabase itemGroupDatabase, ItemDatabase itemDatabase, ValidationService validationService) {
        this.itemGroupDatabase = itemGroupDatabase;
        this.itemDatabase = itemDatabase;
        this.validationService = validationService;
    }

    public void createItemGroup(UUID itemId, int amount) {
        if (!validationService.isValidUUID(itemId.toString())) {
            throw new IllegalArgumentException("Invalid ID.");
        }
        if (!validationService.isValidAmount(amount)) {
            throw new IllegalArgumentException("Amount must be 1 or higher.");
        }

        itemGroupDatabase.addItemGroup(itemId, amount);
    }

    public LocalDate calculateShippingDate(UUID itemId, int amount) {
        LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
        LocalDate nextWeek = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        if (isInStock(itemId, amount)) {
            return tomorrow;
        } else {
            return nextWeek;
        }
    }

    private boolean isInStock(UUID itemId, int amount) {
        try {
            return amount <= getItem(itemId).getAmount();
        } catch (Exception exception) {
            return false;
        }
    }

    public Item getItem(UUID itemId) {
        return itemDatabase.getItem(itemId);
    }

    public double getItemGroupPrice(UUID itemId, int amount) {
        return getItemPrice(itemId) * amount;
    }

    private double getItemPrice(UUID itemId) {
        return getItem(itemId).getPrice();
    }
}
