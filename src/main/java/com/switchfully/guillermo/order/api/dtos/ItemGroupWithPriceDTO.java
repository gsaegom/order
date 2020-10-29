package com.switchfully.guillermo.order.api.dtos;

import com.switchfully.guillermo.order.repository.ItemDatabase;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroupWithPriceDTO {
    private UUID itemId;
    private int amount;
    private LocalDate shippingDate;
    private double groupPrice;

    public ItemGroupWithPriceDTO(UUID itemId, int amount, LocalDate shippingDate,double groupPrice) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.groupPrice = groupPrice;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
