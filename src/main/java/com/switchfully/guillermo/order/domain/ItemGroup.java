package com.switchfully.guillermo.order.domain;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private UUID itemId;
    private int amount;
    private LocalDate shippingDate;
    private double itemGroupPrice;

    public ItemGroup(UUID itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
        //TODO: Use proper default values for shippingDate and itemGroupPrice
        this.shippingDate = LocalDate.now();
        this.itemGroupPrice = 0;
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

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setItemGroupPrice(double itemGroupPrice) {
        this.itemGroupPrice = itemGroupPrice;
    }
}

