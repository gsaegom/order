package com.switchfully.guillermo.order.domain;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private UUID itemId;
    private int amount;
    private LocalDate shippingDate;
    private double itemGroupPrice;

    public ItemGroup(UUID itemId, int amount,LocalDate shippingDate,double itemGroupPrice ) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.itemGroupPrice = itemGroupPrice;
    }


    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public double getItemGroupPrice() {
        return itemGroupPrice;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}

