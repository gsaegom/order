package com.switchfully.guillermo.order.api.dtos;

import java.util.List;

public class OrderWithPriceDTO {
    private List<ItemGroupWithPriceDTO> itemGroups;
    private double totalPrice;


    public OrderWithPriceDTO(List<ItemGroupWithPriceDTO> itemGroups, double totalPrice) {
        this.itemGroups = itemGroups;
        this.totalPrice = totalPrice;
    }

    public List<ItemGroupWithPriceDTO> getItemGroups() {
        return itemGroups;
    }
}