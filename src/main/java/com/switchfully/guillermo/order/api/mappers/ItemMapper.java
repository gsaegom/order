package com.switchfully.guillermo.order.api.mappers;

import com.switchfully.guillermo.order.api.dtos.ItemDTO;
import com.switchfully.guillermo.order.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item convertItemDTOToItem(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getName(), itemDTO.getDescription(),
                itemDTO.getPrice(), itemDTO.getAmount());
        return item;
    }
}
