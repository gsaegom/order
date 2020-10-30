package com.switchfully.guillermo.order.api.dtos;

import com.switchfully.guillermo.order.domain.Stock;

public class ItemWithStockLevelDTO {
    private String name;
    private String description;
    private double price;
    private int amount;
    private Stock stockLevel;

    public ItemWithStockLevelDTO(String name, String description, double price, int amount, Stock stockLevel) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.stockLevel = stockLevel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public Stock getStockLevel() {
        return stockLevel;
    }
}
