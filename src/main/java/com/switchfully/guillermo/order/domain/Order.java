package com.switchfully.guillermo.order.domain;

import java.util.List;

public class Order {
    List<ItemGroup> itemGroups;
    private double totalPrice;

    public Order(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        this.totalPrice = getTotalPrice();

    }

    public double getTotalPrice() {
        return itemGroups.stream()
                .mapToDouble(ItemGroup::getItemGroupPrice)
                .sum();

    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroups;
    }
}
