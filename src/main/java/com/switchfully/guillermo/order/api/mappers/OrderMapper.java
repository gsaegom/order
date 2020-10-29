package com.switchfully.guillermo.order.api.mappers;

import com.switchfully.guillermo.order.api.dtos.ItemGroupWithPriceDTO;
import com.switchfully.guillermo.order.api.dtos.OrderDTO;
import com.switchfully.guillermo.order.api.dtos.OrderWithPriceDTO;
import com.switchfully.guillermo.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {
    private ItemGroupMapper itemGroupMapper;

    public OrderMapper(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    public Order convertOrderDTOToOrder(OrderDTO orderDto) {
        Order order = new Order(itemGroupMapper.convertItemGroupDtoListToItemGroupList(orderDto.getItemGroupListDto()));
        return order;
    }

    public OrderWithPriceDTO convertOrderToOrderWithPriceDto(Order order) {
        List<ItemGroupWithPriceDTO> itemGroupWithPriceDTOList = itemGroupMapper.convertItemGroupListToItemGroupWithPriceDtoList(order.getItemGroupList());
        OrderWithPriceDTO orderWithPriceDTO = new OrderWithPriceDTO(itemGroupWithPriceDTOList, order.getTotalPrice());
        return orderWithPriceDTO;
    }
}
