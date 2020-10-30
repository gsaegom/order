package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.Item;
import com.switchfully.guillermo.order.domain.ItemGroup;
import com.switchfully.guillermo.order.domain.Order;
import com.switchfully.guillermo.order.repository.ItemDatabase;
import com.switchfully.guillermo.order.repository.OrderDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Component
public class OrderService {
    private final OrderDatabase orderDatabase;
    private final ItemDatabase itemDatabase;

    @Autowired
    public OrderService(OrderDatabase orderDatabase, ItemDatabase itemDatabase) {
        this.orderDatabase = orderDatabase;
        this.itemDatabase = itemDatabase;
    }

    public void makeOrder(UUID customerId, Order order) {
        setShippingDateAndGroupPrice(order);
        orderDatabase.addOrder(customerId, order);
    }

    //TODO: name method properly
    public void setShippingDateAndGroupPrice(Order order) {
        for (ItemGroup itemGroup : order.getItemGroupList()) {
            itemGroup.setShippingDate(calculateShippingDate(itemGroup.getItemId(), itemGroup.getAmount()));
            itemGroup.setItemGroupPrice(calculateItemGroupPrice(itemGroup.getItemId(), itemGroup.getAmount()));
        }
    }

    public LocalDate calculateShippingDate(UUID itemId, int amount) {
        LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
        LocalDate nextWeek = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        if (isInStock(itemId, amount)) {
            return tomorrow;
        } else {
            return nextWeek;
        }
    }

    private boolean isInStock(UUID itemId, int amount) {
        try {
            return amount <= getItem(itemId).getAmount();
        } catch (Exception exception) {
            return false;
        }
    }

    public Item getItem(UUID itemId) {
        return itemDatabase.getItem(itemId);
    }

    public double calculateItemGroupPrice(UUID itemId, int amount) {
        return getItemPrice(itemId) * amount;
    }

    private double getItemPrice(UUID itemId) {
        return getItem(itemId).getPrice();
    }
}
