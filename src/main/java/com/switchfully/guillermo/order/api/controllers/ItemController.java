package com.switchfully.guillermo.order.api.controllers;

import com.switchfully.guillermo.order.api.dtos.ItemDTO;
import com.switchfully.guillermo.order.api.dtos.ItemWithStockLevelDTO;
import com.switchfully.guillermo.order.api.mappers.ItemMapper;
import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.domain.Stock;
import com.switchfully.guillermo.order.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addItem(@RequestBody ItemDTO itemDTO, @RequestHeader UUID id) {
        LOGGER.info("Request to add an item");
        Item item = itemMapper.convertItemDtoToItem(itemDTO);
        itemService.addItem(item, id);
        System.out.println(item.getId());
        return itemDTO;
    }

    @GetMapping
    public List<ItemWithStockLevelDTO> getAllItems(@RequestHeader UUID userId) {
        List<Item> allItems = itemService.getAllItems(userId);
        return itemMapper.convertItemListToItemWithStockLevelDtoList(allItems);
    }

    @GetMapping(path = "/{stockLevel}")
    public List<ItemWithStockLevelDTO> getItemsByStockLevel(@PathVariable Stock stockLevel, @RequestHeader UUID userId) {
        List<Item> sortedItems = itemService.getItemsByStockLevel(stockLevel, userId);
        return itemMapper.convertItemListToItemWithStockLevelDtoList(sortedItems);
    }

  // @GetMapping(path = "/test")
  // public List<Item> getAllItemsTest() {
  //     return itemService.getAllItems();
  // }
  //
  //
  // @GetMapping(path = "/dtotest")
  // public List<ItemDTO> getAllItemsDtoTest() {
  //     List<Item> allItems = itemService.getAllItems();
  //     return itemMapper.convertItemListToItemDtoList(allItems);
  // }
}