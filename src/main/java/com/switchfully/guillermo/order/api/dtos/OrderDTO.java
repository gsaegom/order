package com.switchfully.guillermo.order.api.dtos;

import com.switchfully.guillermo.order.domain.ItemGroup;

import java.util.List;

public class OrderDTO {
   private List<ItemGroupDTO> itemGroupListDto;

   //public OrderDTO(List<ItemGroupDTO> itemGroupListDto) {
   //    this.itemGroupListDto = itemGroupListDto;
   //}

    public OrderDTO() {
    }

    public List<ItemGroupDTO> getItemGroupListDto() {
        return itemGroupListDto;
    }

    public void setItemGroupListDto(List<ItemGroupDTO> itemGroupListDto) {
        this.itemGroupListDto = itemGroupListDto;
    }
}
