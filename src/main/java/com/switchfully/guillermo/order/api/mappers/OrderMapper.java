package com.switchfully.guillermo.order.api.mappers;

import com.switchfully.guillermo.order.api.dtos.OrderDTO;
import com.switchfully.guillermo.order.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order convertOrderDTOToOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getItemGroups());
        return order;
    }
}
