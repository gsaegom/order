package com.switchfully.guillermo.order.api.dtos;

import com.switchfully.guillermo.order.repository.ItemDatabase;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroupWithPriceDTO {
    private UUID itemId;
    private int amount;
    private double groupPrice;
    private LocalDate shippingDate;

    public ItemGroupWithPriceDTO(UUID itemId, int amount, double groupPrice, LocalDate shippingDate) {
        this.itemId = itemId;
        this.amount = amount;
        this.groupPrice = groupPrice;
        this.shippingDate = shippingDate;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
