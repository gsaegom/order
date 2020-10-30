package com.switchfully.guillermo.order.domain;

import java.util.UUID;

public class Item {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private int amount;
    private Stock stockLevel;

    //TODO:Do something with negative amounts and prices
    public Item(UUID id, String name, String description, double price, int amount, Stock stockLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.stockLevel = stockLevel;
    }

    public Item(String name, String description, double price, int amount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.stockLevel = Stock.HIGH;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public Stock getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Stock stockLevel) {
        this.stockLevel = stockLevel;
    }
}
