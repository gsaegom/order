package com.switchfully.guillermo.order.domain;

import java.util.UUID;

public class Item {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private int amount;

    public Item(String name, String description, double price, int amount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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
}
