package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.domain.Stock;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ItemDatabase {
    Map<UUID, Item> itemDatabase = new HashMap<>();


    public Item addItem(Item item) {
        itemDatabase.put(item.getId(), item);
        return itemDatabase.get(item.getId());
    }

    public Item getItem(UUID id) {
        return itemDatabase.get(id);
    }

    public List<Item> getAllItems() {
        if (itemDatabase.isEmpty()) throw new NullPointerException("This database is empty");
        return itemDatabase.values().stream().sorted(Comparator.comparingInt(Item::getAmount)).collect(Collectors.toList());
    }

    public List<Item> getItemsByStockLevel(Stock stockLevel) {
        return getAllItems().stream()
                .filter(item -> item.getStockLevel().equals(stockLevel))
                .collect(Collectors.toList());
    }

}
