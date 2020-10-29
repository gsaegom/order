package com.switchfully.guillermo.order.api.mappers;

import com.switchfully.guillermo.order.api.dtos.ItemGroupDTO;
import com.switchfully.guillermo.order.domain.ItemGroup;

public class ItemGroupMapper {
    public ItemGroup itemGroupDTOToItemGroup(ItemGroupDTO itemGroupDTO) {
        ItemGroup itemgroup = new ItemGroup(itemGroupDTO.getItemId(), itemGroupDTO.getAmount());
        return itemgroup;
    }
}
