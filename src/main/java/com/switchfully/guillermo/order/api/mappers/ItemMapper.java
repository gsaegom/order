package com.switchfully.guillermo.order.api.mappers;

import com.switchfully.guillermo.order.api.dtos.ItemDTO;
import com.switchfully.guillermo.order.api.dtos.ItemWithStockLevelDTO;
import com.switchfully.guillermo.order.domain.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    public Item convertItemDtoToItem(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getName(), itemDTO.getDescription(),
                itemDTO.getPrice(), itemDTO.getAmount());
        return item;
    }

    public ItemDTO convertItemToItemDto(Item item) {
        ItemDTO itemDTO = new ItemDTO(item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
        return itemDTO;
    }

    public ItemWithStockLevelDTO convertItemToItemWithStockLevelDto(Item item) {
        ItemWithStockLevelDTO itemWithStockLevelDTO = new ItemWithStockLevelDTO(item.getName(), item.getDescription(), item.getPrice(), item.getAmount(), item.getStockLevel());
        return itemWithStockLevelDTO;
    }

    public List<ItemDTO> convertItemListToItemDtoList(List<Item> allItems) {
        List<ItemDTO> itemDTOList = allItems.stream()
                .map(item -> convertItemToItemDto(item))
                .collect(Collectors.toList());
        return itemDTOList;
    }

    public List<ItemWithStockLevelDTO> convertItemListToItemWithStockLevelDtoList(List<Item> allItems) {
        List<ItemWithStockLevelDTO> itemWithStockLevelDTOList = allItems.stream()
                .map(item -> convertItemToItemWithStockLevelDto(item))
                .collect(Collectors.toList());
        return itemWithStockLevelDTOList;
    }
}
