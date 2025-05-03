package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.UomDto;
import com.oee.dto.mapper.UomMapper;
import com.oee.entity.UomEntity;
import com.oee.exception.BRSException;
import com.oee.repository.UomRepository;
import com.oee.service.UomService;

@Service
public class UomServiceImpl implements UomService {

	@Autowired
	UomRepository uomRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(UomServiceImpl.class);

	@Override
	public List<UomDto> getAllUoms() {
		// TODO Auto-generated method stub
		
		List<UomEntity> uomEntityList = uomRepository.findAll();
		  
		  if (uomEntityList == null) 
		  { 
			  throw  BRSException.throwException("UOM List does not exist"); 
		  }
		  
		  return UomMapper.toUomDtoList(uomEntityList);
		  
		
	}
	
	@Override
	public List<UomDto> getAllActiveUoms() {
		// TODO Auto-generated method stub
		
		List<UomEntity> uomEntityList = uomRepository.findByIsdeleted("N");
		  
		  if (uomEntityList == null) 
		  { 
			  throw  BRSException.throwException("UOM List does not exist"); 
		  }
		  
		  return UomMapper.toUomDtoList(uomEntityList);
		  
		
	}

	@Override
	public UomEntity getUomByID(String uomid) {
		// TODO Auto-generated method stub
		logger.info("----- UomServiceImpl getUomByID -----");
		
		UomEntity uomEntity = uomRepository.findById(uomid).get();
		
		if (uomEntity == null) {
			throw BRSException.throwException("Uom Details does not exist.");
		}
		
		return uomEntity;	
		}	}

	