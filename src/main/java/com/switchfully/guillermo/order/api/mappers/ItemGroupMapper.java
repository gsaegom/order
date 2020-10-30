package com.switchfully.guillermo.order.api.mappers;

import com.switchfully.guillermo.order.api.dtos.ItemGroupDTO;
import com.switchfully.guillermo.order.api.dtos.ItemGroupWithPriceDTO;
import com.switchfully.guillermo.order.domain.ItemGroup;
import com.switchfully.guillermo.order.services.ItemGroupService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemGroupMapper {

    //public ItemGroup convertItemGroupWithPriceDtoToItemGroup(ItemGroupWithPriceDTO itemGroupWithPriceDTO) {
    //    ItemGroup itemgroup = new ItemGroup(itemGroupWithPriceDTO.getItemId(), itemGroupWithPriceDTO.getAmount(),);
    //    return itemgroup;
    //}

    public ItemGroup convertItemGroupDtoToItemGroup(ItemGroupDTO itemGroupDto) {
        ItemGroup itemGroup = new ItemGroup(itemGroupDto.getItemId(), itemGroupDto.getAmount());
        return itemGroup;
    }

    public ItemGroupWithPriceDTO convertItemGroupToItemGroupWithPriceDto(ItemGroup itemGroup) {
        ItemGroupWithPriceDTO itemGroupWithPriceDTO = new ItemGroupWithPriceDTO(itemGroup.getItemId(), itemGroup.getAmount(), itemGroup.getShippingDate(), itemGroup.getItemGroupPrice());
        return itemGroupWithPriceDTO;
    }

    public List<ItemGroup> convertItemGroupDtoListToItemGroupList(List<ItemGroupDTO> itemGroupDTOList) {
        List<ItemGroup> itemGroupList = itemGroupDTOList.stream()
                .map(itemGroupDTO -> convertItemGroupDtoToItemGroup(itemGroupDTO))
                .collect(Collectors.toList());
        return itemGroupList;
    }

    public List<ItemGroupWithPriceDTO> convertItemGroupListToItemGroupWithPriceDtoList(List<ItemGroup> itemGroupList) {
        List<ItemGroupWithPriceDTO> itemGroupWithPriceDTOList = itemGroupList.stream()
                .map(itemGroup -> convertItemGroupToItemGroupWithPriceDto(itemGroup))
                .collect(Collectors.toList());
        return itemGroupWithPriceDTOList;
    }

}
