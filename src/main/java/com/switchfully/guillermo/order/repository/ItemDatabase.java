package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class ItemDatabase {
    Map<UUID, Item> itemDatabase;

    public ItemDatabase() {
        this.itemDatabase = new HashMap<>();
    }

    public Item addItem(Item item) {
        itemDatabase.put(item.getId(), item);
        return itemDatabase.get(item.getId());
    }

    public Item getItem(UUID id) {
        return itemDatabase.get(id);
    }
}
