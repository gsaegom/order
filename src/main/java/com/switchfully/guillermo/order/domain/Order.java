package com.switchfully.guillermo.order.domain;

import java.util.List;

public class Order {
    List<ItemGroup> itemGroups;
    private double totalPrice;

    public Order(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        this.totalPrice = getTotalPrice(itemGroups);

    }

    public double getTotalPrice(List<ItemGroup> itemGroups) {
        return itemGroups.stream()
                .mapToDouble(ItemGroup::getGroupPrice)
                .sum();

    }

}
