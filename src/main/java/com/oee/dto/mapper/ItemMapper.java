package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.ItemDto;
import com.oee.entity.ItemEntity;

public class ItemMapper {

	public static ItemDto toItemDto(ItemEntity itemEntity) {
		return new ItemDto()
				.setItemid(itemEntity.getId())
				.setItemcode(itemEntity.getItemcode())
				.setItemdesc(itemEntity.getItemdesc())
				.setIsdeleted(itemEntity.getIsdeleted().equalsIgnoreCase("Y") ? "Active" : "Inactive");
				
	}
	
	public static List<ItemDto> toItemDtoList(List<ItemEntity> ItemEntityList) {
		List<ItemDto> ItemDtos = new ArrayList<ItemDto>();
		
		for(ItemEntity ItemEntity : ItemEntityList) {
			ItemDtos.add(toItemDto(ItemEntity));
		}
		
		return ItemDtos;
	}
	
}
