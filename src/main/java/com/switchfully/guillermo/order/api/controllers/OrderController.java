package com.switchfully.guillermo.order.api.controllers;

import com.switchfully.guillermo.order.api.dtos.OrderDTO;
import com.switchfully.guillermo.order.api.dtos.OrderWithPriceDTO;
import com.switchfully.guillermo.order.api.mappers.OrderMapper;
import com.switchfully.guillermo.order.domain.ItemGroup;
import com.switchfully.guillermo.order.domain.Order;
import com.switchfully.guillermo.order.services.ItemGroupService;
import com.switchfully.guillermo.order.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper, ItemGroupService itemGroupService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping(path = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderWithPriceDTO makeOrder(@RequestBody OrderDTO orderDto, @PathVariable UUID customerId) {
        LOGGER.info("Request to register an order");
        Order order = orderMapper.convertOrderDTOToOrder(orderDto);
        orderService.makeOrder(customerId, order);
        OrderWithPriceDTO orderWithPriceDTO = orderMapper.convertOrderToOrderWithPriceDto(order);
        return orderWithPriceDTO;
    }
}
