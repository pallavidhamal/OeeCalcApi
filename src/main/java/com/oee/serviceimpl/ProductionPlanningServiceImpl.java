package com.oee.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.incoming.ProductionPlanningIncomingDto;
import com.oee.entity.ProductionPlanningEntity;
import com.oee.repository.StationRepository;
import com.oee.service.ItemService;
import com.oee.service.ProductionPlanningService;
import com.oee.service.SetUpService;
import com.oee.service.StationService;
import com.oee.util.AuthenticationService;

@Service
public class ProductionPlanningServiceImpl implements ProductionPlanningService {

	
	@Autowired
	StationRepository stationRepository;
	
	

	@Autowired
	ItemService itemService;
	@Autowired
	SetUpService setupService;

	@Autowired
	StationService stationService;
	

	
	@Override
	public List<ProductionPlanningEntity> getProductionPlanEntities(
			List<ProductionPlanningIncomingDto> productionPlanningIncomingDtoList) {
		// TODO Auto-generated method stub
		
		
		List<ProductionPlanningEntity>	productionPlanningEntities	= new ArrayList<ProductionPlanningEntity>();
		
		productionPlanningIncomingDtoList.forEach(productionPlanningIncomingDto->{
		
			
			ProductionPlanningEntity	productionPlanningEntity=new ProductionPlanningEntity();  
			
			productionPlanningEntity.setItem(itemService.getItemByID(productionPlanningIncomingDto.getItemid()));
			productionPlanningEntity.setSetup(setupService.getSetUpById(productionPlanningIncomingDto.getSetupid()));
			productionPlanningEntity.setSetuptime(productionPlanningIncomingDto.getSetuptime());
			productionPlanningEntity.setCycletime(productionPlanningIncomingDto.getCycletime());
			productionPlanningEntity.setQty_planned(productionPlanningIncomingDto.getPlannedquantity());
			productionPlanningEntity.setMins_planned(productionPlanningIncomingDto.getPlannedmins());
			productionPlanningEntity.setQty_produced(productionPlanningIncomingDto.getProducedquantity());
			productionPlanningEntity.setQty_rejected(productionPlanningIncomingDto.getRejectedquantity());
			productionPlanningEntity.setIsdeleted("N");
			productionPlanningEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
			
			productionPlanningEntities.add(productionPlanningEntity);
			
		});
		
		
		
		
		return productionPlanningEntities;
		
		
		
		
		
		
	}

}
