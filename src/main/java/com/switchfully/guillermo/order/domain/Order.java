package com.switchfully.guillermo.order.domain;

import java.util.List;

public class Order {
    List<ItemGroup> itemGroupList;
    private double totalPrice;

    public Order(List<ItemGroup> itemGroupList) {
        this.itemGroupList = itemGroupList;
        this.totalPrice = getTotalPrice();

    }

    public double getTotalPrice() {
        return itemGroupList.stream()
                .mapToDouble(ItemGroup::getItemGroupPrice)
                .sum();

    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }
}
