package com.oee.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.incoming.ProductionPlanningIncomingDto;
import com.oee.entity.PlanningShiftWorkEntity;
import com.oee.entity.ProductionPlanningEntity;
import com.oee.repository.StationRepository;
import com.oee.service.ItemService;
import com.oee.service.PlanningService;
import com.oee.service.ProductionPlanningService;
import com.oee.service.ProductionService;
import com.oee.service.SetUpService;
import com.oee.service.StationService;

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
		
			
			ProductionPlanningEntity	productionPlanningEntity=null;  
			
			productionPlanningEntity.setItem(itemService.getItemByID(productionPlanningIncomingDto.getItemid()));
			productionPlanningEntity.setSetup(setupService.getSetUpById(productionPlanningIncomingDto.getSetupid()));
	
			
			//	productionPlanningEntity.setQty_planned(null)
			

			
			
			
			
			//productionPlanningEntity.setProductionentity(productionService.getPlanningEntityByID(productionPlanningIncomingDto.getPlanid()));
			
			//productionPlanningEntity.setProductionentity(planningService.get)
			
			
			
		});
		
		
		
		
		return null;
		
		
		
		
		
		
	}

}
