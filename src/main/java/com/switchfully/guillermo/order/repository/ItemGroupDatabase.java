package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.domain.ItemGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ItemGroupDatabase {
    List<ItemGroup> itemGroupList;
    ItemDatabase itemDatabase;


    public ItemGroupDatabase(ItemDatabase itemDatabase) {
        this.itemGroupList = new ArrayList<>();
        this.itemDatabase = itemDatabase;
    }

   // public void addItemGroup(UUID itemId, int amount) {
   //     ItemGroup itemGroup = new ItemGroup(itemId, amount, calculateShippingDate(itemId, amount), getItemGroupPrice(itemId, amount));
   //
   // }

    private LocalDate calculateShippingDate(UUID itemId, int amount) {
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

    private double getItemGroupPrice(UUID itemId, int amount) {
        return getItemPrice(itemId) * amount;
    }

    private double getItemPrice(UUID itemId) {
        return getItem(itemId).getPrice();
    }
}
