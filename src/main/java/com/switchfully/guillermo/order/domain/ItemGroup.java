package com.switchfully.guillermo.order.domain;

import com.switchfully.guillermo.order.repository.ItemDatabase;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class ItemGroup {
    private UUID itemId;
    private int amount;
    private LocalDate shippingDate;
    private ItemDatabase itemDatabase;
    private double groupPrice;

    public ItemGroup(UUID itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
        //   calculateShippingDate(itemId);
        //  this.groupPrice = getItemPrice(itemId) * amount;
        this.groupPrice = 5;
        this.shippingDate = LocalDate.now();
    }

    private void calculateShippingDate(UUID itemId) {
        LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
        LocalDate nextWeek = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        if (isInStock(itemId)) {
            this.shippingDate = tomorrow;
        } else {
            this.shippingDate = nextWeek;
        }
    }

    private boolean isInStock(UUID itemId) {
        try {
            return this.amount <= getItem(itemId).getAmount();
        } catch (Exception exception) {
            return false;
        }
    }

    public Item getItem(UUID itemId) {
        return itemDatabase.getItem(itemId);
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    private double getItemPrice(UUID itemId) {
        return getItem(itemId).getPrice();
    }


    public double getGroupPrice() {
        return groupPrice;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}

