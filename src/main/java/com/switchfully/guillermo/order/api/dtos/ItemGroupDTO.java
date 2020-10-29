package com.switchfully.guillermo.order.api.dtos;

import java.util.UUID;

public class ItemGroupDTO {
    private UUID itemId;
    private int amount;

   // public ItemGroupDTO(UUID itemId, int amount) {
   //     this.itemId = itemId;
   //     this.amount = amount;
   // }


    public ItemGroupDTO() {
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

