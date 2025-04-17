package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.ItemDto;
import com.oee.dto.incoming.ItemIncomingDto;
import com.oee.dto.mapper.ItemMapper;
import com.oee.entity.ItemEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.ItemRepository;
import com.oee.service.ItemService;
import com.oee.util.AuthenticationService;

@Service
public class WorkcenterServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(WorkcenterServiceImpl.class);

	
	@Override
	public List<ItemDto> getAllItems() {
		
		// TODO Auto-generated method stub
		//logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		List<ItemEntity> itemEntityList = itemRepository.findAll();
		
		if (itemEntityList == null) {
			throw BRSException.throwException("Item List does not exist");
		}
		
		return ItemMapper.toItemDtoList(itemEntityList);
		
	}

	@Override
	public ItemEntity getItemByID(String fittingTypeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(ItemIncomingDto itemIncomingDto) {
		// TODO Auto-generated method stub

		
			if (itemIncomingDto.getItemcode() == "") {
						
						throw BRSException.throwException(EntityType.ITEMCODE, ExceptionType.BLANK_VALUE, "Item Code");				
			}
			if (itemIncomingDto.getItemdesc() == "") {
				
				throw BRSException.throwException(EntityType.ITEMDESC, ExceptionType.BLANK_VALUE, "Item Desc");				
			}
		
		  ItemEntity itemEntity = new ItemEntity();
		  itemEntity.setItemcode(itemIncomingDto.getItemcode());
		  itemEntity.setItemdesc(itemIncomingDto.getItemdesc());
		  itemEntity.setIsdeleted("N");
		  
		  itemEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		  
		  itemRepository.save(itemEntity);
		  
		  logger.info("--- Item Added Successfully ----");
		  
		  return true;
		 
	}

	@Override
	public boolean editItem(ItemIncomingDto itemIncomingDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(String itemid) {
		// TODO Auto-generated method stub
		return false;
	}

}
