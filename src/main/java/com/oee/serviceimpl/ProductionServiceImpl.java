package com.oee.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.incoming.ProductionIncomingDto;
import com.oee.entity.ProductionEntity;
import com.oee.entity.StationEntity;
import com.oee.entity.StationTypeEntity;
import com.oee.entity.UomEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.ProductionRepository;
import com.oee.repository.StationRepository;
import com.oee.service.ProductionService;
import com.oee.util.AuthenticationService;

@Service
public class ProductionServiceImpl implements ProductionService {

	
	@Autowired
	ProductionRepository productionRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(StationServiceImpl.class);

	
	@Override
	public boolean addProduction(ProductionIncomingDto productionIncomingDto) {
		// TODO Auto-generated method stub
		  ProductionEntity productionEntity =new ProductionEntity();
			 
		  
		  productionEntity.setAvailability_teatime(productionIncomingDto.getAvailability_teatime());
		  productionEntity.setAvailability_reviewtime(productionIncomingDto.getAvailability_reviewtime());
		  productionEntity.setAvailability_inpectiontime(productionIncomingDto.getAvailability_inpectiontime());
		  productionEntity.setAvailability_machinebreakdown(productionIncomingDto.getAvailability_machinebreakdown());
		  productionEntity.setAvailability_setupchange(productionIncomingDto.getAvailability_setupchange());
		  productionEntity.setAvailability_nomaterial(productionIncomingDto.getAvailability_nomaterial());
		  productionEntity.setAvailability_nolabour(productionIncomingDto.getAvailability_nolabour());
		  productionEntity.setAvailability_inspection(productionIncomingDto.getAvailability_inspection());

		  
		  productionEntity.setAvailability_tooling(productionIncomingDto.getAvailability_tooling());
		  productionEntity.setAvailability_drawing(productionIncomingDto.getAvailability_drawing());
		  productionEntity.setAvailability_guages(productionIncomingDto.getAvailability_guages());
		  productionEntity.setAvailability_otherlosses(productionIncomingDto.getAvailability_otherlosses());
		  productionEntity.setAvailability_calculation(productionIncomingDto.getAvailability_calculation());
		  productionEntity.setAvailability_time(productionIncomingDto.getAvailability_time());
		  productionEntity.setAvailability_per(productionIncomingDto.getAvailability_per());

		  
		  productionEntity.setCompany(null);
		  productionEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		  productionEntity.setDate(null);
		  productionEntity.setIsdeleted("N");
		  
		  
		  //productionEntity.setProductionPlanningEntities(null);
		  
		  productionEntity.setProductivity_per(productionIncomingDto.getProductivity_per());
		  productionEntity.setProductivity_personnal(productionIncomingDto.getProductivity_personnal());
		  productionEntity.setProductivity_Production_qty(productionIncomingDto.getProductivity_Production_qty());
		  productionEntity.setProductivity_rework(productionIncomingDto.getProductivity_rework());
		  productionEntity.setProductivity_searching(productionIncomingDto.getProductivity_searching());
		  productionEntity.setProductivity_standard_qty(productionIncomingDto.getProductivity_standard_qty());
		  
		  productionEntity.setRejection_ok_qty(productionIncomingDto.getRejection_ok_qty());
		  productionEntity.setRejection_rejection_qty(productionIncomingDto.getRejection_rejection_qty());
		  productionEntity.setRejection_per(productionIncomingDto.getRejection_per());
		  
		  
		  productionRepository.save(productionEntity);
		  
		  logger.info("--- Production Added Successfully ----");
		 
		  
		  return true;
	}

}
