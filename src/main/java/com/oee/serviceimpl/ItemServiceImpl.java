package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.ItemDto;
import com.oee.dto.incoming.ItemIncomingDto;
import com.oee.dto.mapper.ItemMapper;
import com.oee.dto.mapper.StationMapper;
import com.oee.entity.ItemEntity;
import com.oee.entity.StationEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.ItemRepository;
import com.oee.service.ItemService;
import com.oee.util.AuthenticationService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	
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
	public ItemDto getItemById(String itemid) {
		// TODO Auto-generated method stub
		logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		ItemEntity itemEntity = itemRepository.findById(itemid).get();
		
		if (itemEntity == null) {
			throw BRSException.throwException("Item Details does not exist.");
		}
		
		return ItemMapper.toItemDto(itemEntity);
		
		}

	
	@Override
	public boolean addItem(ItemIncomingDto itemIncomingDto) {
		// TODO Auto-generated method stub
		ItemEntity itemEntity  = new ItemEntity();
		
		
		  if (itemIncomingDto.getItemcode() == "") {
		  
		  throw BRSException.throwException(EntityType.ITEMCODE,ExceptionType.BLANK_VALUE, "Item Code"); 
		  
		  } 
		  if (itemIncomingDto.getItemdesc()  == "") {
		  
		  throw BRSException.throwException(EntityType.ITEMDESC, ExceptionType.BLANK_VALUE, "Item Desc"); 
		  
		  }
		 
		
		  ItemEntity itemExistEntity = itemRepository.findByItemcode(itemIncomingDto.getItemcode());
		  if(itemExistEntity != null)
		  {
			  throw BRSException.throwException(EntityType.ITEM, ExceptionType.ALREADY_EXIST, itemIncomingDto.getItemcode());
		  
		  }
			 
			
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
		
			if (itemIncomingDto.getItemcode() == "") {
				
				throw BRSException.throwException(EntityType.ITEMCODE, ExceptionType.BLANK_VALUE, "Item Code");				
			}
			if (itemIncomingDto.getItemdesc() == "") {
				
				throw BRSException.throwException(EntityType.ITEMDESC, ExceptionType.BLANK_VALUE, "Item Desc");				
			}
			
			ItemEntity itemcodeEntity  = itemRepository.findByItemcode(itemIncomingDto.getItemcode());
			
			if(itemcodeEntity != null) {
				throw BRSException.throwException(EntityType.ITEM, ExceptionType.ALREADY_EXIST, itemIncomingDto.getItemcode());
			}
			
			// Check If HT Part ID exists in HT Part Entity
			ItemEntity itemEntity  = itemRepository.findById(itemIncomingDto.getItemid()).get();
			
			if(itemEntity == null) {
				throw BRSException.throwException(EntityType.ITEM, ExceptionType.ENTITY_NOT_FOUND, itemIncomingDto.getItemid());
			}
			
			
			  itemEntity.setItemcode(itemIncomingDto.getItemcode());
			  itemEntity.setItemdesc(itemIncomingDto.getItemdesc());
			  itemEntity.setIsdeleted("N");
			  
			  itemEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
			  
			  itemRepository.save(itemEntity);
			  
			
			 return true;
	}

	@Override
	public boolean deleteItem(String itemid) {
		// TODO Auto-generated method stub
		logger.info("------ delete item -------");
		
		ItemEntity itemEntity = itemRepository.findById(itemid).get();
		
		if (itemEntity == null) {
			throw BRSException.throwException(EntityType.ITEM, ExceptionType.ENTITY_NOT_FOUND, itemid);	
			
		}
		
		itemEntity.setIsdeleted(itemEntity.getIsdeleted().equalsIgnoreCase("Y") ? "N" : "Y");
		itemEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
		
		itemRepository.save(itemEntity);
		
		logger.info("------ Item Deleted Successfully ------");
		
		return true;		
	}

	@Override
	public ItemEntity getItemByID(String itemId) {
		// TODO Auto-generated method stub
		 ItemEntity itemEntity = itemRepository.findById(itemId).get();
		  
		  if (itemEntity == null) { throw BRSException.throwException(EntityType.ITEM,
		  ExceptionType.ENTITY_NOT_FOUND, itemId);
		  }
		  return itemEntity;
	}

	@Override
	public List<ItemDto> getActiveItems() {
				
		List<ItemEntity> itemEntityList = itemRepository.findByIsdeleted("N");
		
		if (itemEntityList == null) {
			throw BRSException.throwException("Item List does not exist");
		}
		
		return ItemMapper.toItemDtoList(itemEntityList);		
		
		
	}

	
	


}
