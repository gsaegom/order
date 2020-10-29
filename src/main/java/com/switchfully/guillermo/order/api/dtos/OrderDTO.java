package com.switchfully.guillermo.order.api.dtos;

import com.switchfully.guillermo.order.domain.ItemGroup;

import java.util.List;

public class OrderDTO {
    List<ItemGroup> itemGroups;


    public OrderDTO(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}