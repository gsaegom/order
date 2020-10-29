package com.switchfully.guillermo.order.api.dtos;

import com.switchfully.guillermo.order.repository.ItemDatabase;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroupDTO {
    private UUID itemId;
    private int amount;

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
