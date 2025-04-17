package com.oee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oee.dto.ItemDto;
import com.oee.dto.incoming.ItemIncomingDto;
import com.oee.dto.response.Response;
import com.oee.entity.ItemEntity;


public interface WorkcenterService {

	List<ItemDto> getAllItems();
	
	ItemEntity getItemByID(String fittingTypeID);
	
	boolean addItem( ItemIncomingDto itemIncomingDto);
	boolean editItem( ItemIncomingDto itemIncomingDto);
	boolean deleteItem(String itemid);
	
}
