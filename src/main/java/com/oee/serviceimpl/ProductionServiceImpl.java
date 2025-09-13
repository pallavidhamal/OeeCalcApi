package com.oee.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.ProductWorkcenterUnitWiseOeeReportRecord;
import com.oee.dto.ProductWorkcenteroeeSummaryRecord;
import com.oee.dto.ProductWorkcenteroeeSummaryResponseRecord;
import com.oee.dto.ProductionDto;
import com.oee.dto.ProductionLossSummaryRecord;
import com.oee.dto.incoming.ProductionIncomingDto;
import com.oee.dto.mapper.ProductionMapper;
import com.oee.entity.OperatorEntity;
import com.oee.entity.ProductionEntity;
import com.oee.entity.ShiftEntity;
import com.oee.entity.StationEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.repository.ProductionRepository;
import com.oee.service.OperatorService;
import com.oee.service.PlanningService;
import com.oee.service.ProductionPlanningService;
import com.oee.service.ProductionService;
import com.oee.service.ShiftService;
import com.oee.service.StationService;
import com.oee.service.UnitService;
import com.oee.service.WorkcenterService;
import com.oee.util.AuthenticationService;

@Service
public class ProductionServiceImpl implements ProductionService {

	
	@Autowired
	ProductionRepository productionRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(StationServiceImpl.class);

	@Autowired
	ProductionPlanningService productionPlanningService;   
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	ShiftService shiftService;
	
	@Autowired
	WorkcenterService wsService;
	
	@Autowired
	OperatorService opService;
	
	@Autowired
	StationService stService;
	
	@Autowired
	PlanningService planService;
	
	@Override
	public boolean addProduction(ProductionIncomingDto productionIncomingDto) {
		// TODO Auto-generated method stub
		  ProductionEntity productionEntity =new ProductionEntity();
		  
		  
		  productionEntity.setPlanningEntity(planService.getPlanningEntityByID(productionIncomingDto.getPlanid()));
		  productionEntity.setUnitentity(unitService.getEntityById(productionIncomingDto.getUnitid()));
		  productionEntity.setWorkcenterentity(wsService.getWorkcenterByID(productionIncomingDto.getWorkcenterid()));
   			productionEntity.setShiftEntity(shiftService.getShiftByID(productionIncomingDto.getShiftid()));
   			productionEntity.setOperatorEntity(opService.getOperatorByID(productionIncomingDto.getOperatorid()));
   			productionEntity.setStationEntity(stService.getStationEntityByID(productionIncomingDto.getStationid()));
 
   			
		  productionEntity.setAvailability_lunchtime(productionIncomingDto.getAvailability_lunchtime());
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
		  productionEntity.setAvailability_overtime(productionIncomingDto.getAvailability_overtime());
		  productionEntity.setAvailability_totaltime(productionIncomingDto.getAvailability_totaltime());
		  productionEntity.setAvailability_stdloss(productionIncomingDto.getAvailability_stdloss());
		  productionEntity.setAvailability_specloss(productionIncomingDto.getAvailability_specloss());
		  productionEntity.setAvailability_totloss(productionIncomingDto.getAvailability_totloss());
		  productionEntity.setAvailability_time(productionIncomingDto.getAvailability_time());
		  productionEntity.setAvailability_per(productionIncomingDto.getAvailability_per());

		  productionEntity.setCompany(null);
		  productionEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		  productionEntity.setProddate(productionIncomingDto.getProddate());
		  productionEntity.setIsdeleted("N");
		  //productionEntity.setProductionPlanningEntities(null);
		  
		  productionEntity.setProductivity_per(productionIncomingDto.getProductivity_per());
		  productionEntity.setProductivity_personnal(productionIncomingDto.getProductivity_personnal());
		  
		  productionEntity.setProductivity_Production_availabletime_qty(productionIncomingDto.getProductivity_Production_availabletime_qty());
		  productionEntity.setProductivity_total_utilised_time(productionIncomingDto.getProductivity_total_utilised_time());
		  productionEntity.setProductivity_Production_qty(productionIncomingDto.getProductivity_Production_qty());
		  productionEntity.setProductivity_rework(productionIncomingDto.getProductivity_rework());
		  productionEntity.setProductivity_searching(productionIncomingDto.getProductivity_searching());
		  productionEntity.setProductivity_standard_qty(productionIncomingDto.getProductivity_standard_qty());
		  productionEntity.setTotal_planned(productionIncomingDto.getTotal_planned());
		  
		  
		  productionEntity.setAchievement_per(productionIncomingDto.getAchievement_per());
		  
		  productionEntity.setRejection_ok_qty(productionIncomingDto.getRejection_ok_qty());
		  productionEntity.setRejection_rejection_qty(productionIncomingDto.getRejection_rejection_qty());
		  productionEntity.setQuality_per(productionIncomingDto.getQuality_per());
		  productionEntity.setRejection_per(productionIncomingDto.getRejection_per());
		  productionEntity.setOee_per(productionIncomingDto.getOee_per());
		  productionEntity.setTot_planned_mins(productionIncomingDto.getTot_planned_mins());
		  
		  logger.info("---  productionIncomingDto.getTot_planned_mins() ----"+ productionIncomingDto.getTot_planned_mins());
		 
		  
		  productionEntity.setProductionPlanningEntities(productionPlanningService.getProductionPlanEntities(productionIncomingDto.getProductionPlanningIncomingDto()));
		  
		  productionRepository.save(productionEntity);
		  
		  logger.info("--- Production Added Successfully ----");
		 
		  
		  return true;
	}

	@Override
	public List<ProductionDto> getAllProduction() {
		// TODO Auto-generated method stub
		List<ProductionEntity> prodEntityList = productionRepository.findAll();

		if (prodEntityList == null) {
			throw BRSException.throwException("Production List does not exist");
		}
		return ProductionMapper.toOnlyProductionDtoList(prodEntityList);
		
		
		
	}

	@Override
	public ProductionDto getProductionByID(String prodID) {
		// TODO Auto-generated method stub
		
		
			// TODO Auto-generated method stub
		ProductionEntity productionEntity = productionRepository.findByIdAndProductionPlanningEntities_Isdeleted(prodID,"N");

			if (productionEntity == null) {
				throw BRSException.throwException("Production Details does not exist.");
			}

			return ProductionMapper.toProductionDto(productionEntity);
	}
	
	@Override
	public List<Map<String, String>> getFilterProductions(ProductionIncomingDto productionIncomingDto) {
		// TODO Auto-generated method stub
		
		
//		UnitEntity unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());
		
		UnitEntity unitEntity = new UnitEntity();
		if(!productionIncomingDto.getUnitid().equalsIgnoreCase("0")){
			unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());	
		}
		
		ShiftEntity shiftEntity =new ShiftEntity();
		if(!productionIncomingDto.getShiftid().equalsIgnoreCase("0")) {
			shiftEntity= shiftService.getActiveShiftByID(productionIncomingDto.getShiftid());
		}
		
		WorkcenterEntity wsEntity = new WorkcenterEntity();
		if(!productionIncomingDto.getWorkcenterid().equalsIgnoreCase("0")){
		 wsEntity = wsService.getActiveWorkcenterByID(productionIncomingDto.getWorkcenterid());		
		}
		
		StationEntity stationEntity=new StationEntity();
		if(!productionIncomingDto.getStationid().equalsIgnoreCase("0")){
		 stationEntity= stService.getStationEntityByID(productionIncomingDto.getStationid());
		}
		
		OperatorEntity operatEntity=new OperatorEntity();
		if(!productionIncomingDto.getOperatorid().equalsIgnoreCase("0")){	
		operatEntity=opService.getOperatorByID(productionIncomingDto.getOperatorid());
		}
		
		List<Map<String, String>> productionEntity = productionRepository.getFilterProductions(unitEntity.getId(),wsEntity.getId(),shiftEntity.getId(),stationEntity.getId(),operatEntity.getId(),productionIncomingDto.getFromdate(),productionIncomingDto.getTodate(),"N");
		
		
		return productionEntity;
		
		
	}

	@Override
	public List<ProductionDto> getPlanVsActual(ProductionIncomingDto productionIncomingDto) {
		// TODO Auto-generated method stub
		
		//UnitEntity unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());
		
		UnitEntity unitEntity = new UnitEntity();
		if(!productionIncomingDto.getUnitid().equalsIgnoreCase("0")){
			unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());	
		}
		
		WorkcenterEntity wsEntity = new WorkcenterEntity();
		if(!productionIncomingDto.getWorkcenterid().equalsIgnoreCase("0")){
		 wsEntity = wsService.getActiveWorkcenterByID(productionIncomingDto.getWorkcenterid());		
		}
		
		StationEntity stationEntity=new StationEntity();
		if(!productionIncomingDto.getStationid().equalsIgnoreCase("0")){
		 stationEntity= stService.getStationEntityByID(productionIncomingDto.getStationid());
		}
		
		/*
		 * ShiftEntity shiftEntity =new ShiftEntity();
		 * if(!productionIncomingDto.getShiftid().equalsIgnoreCase("0")) { shiftEntity=
		 * shiftService.getActiveShiftByID(productionIncomingDto.getShiftid()); }
		 * 
		 * OperatorEntity operatEntity=new OperatorEntity();
		 * if(!productionIncomingDto.getOperatorid().equalsIgnoreCase("0")){
		 * operatEntity=opService.getOperatorByID(productionIncomingDto.getOperatorid())
		 * ; }
		 */
		
		List<ProductionEntity> prodEntityList = productionRepository.getFilterProductions(unitEntity.getId(),wsEntity.getId(),stationEntity.getId(),productionIncomingDto.getFromdate(),productionIncomingDto.getTodate(),"N");
		
		
		return ProductionMapper.toProductionDtoList(prodEntityList);
		
	}

	@Override
	public List<ProductWorkcenteroeeSummaryResponseRecord> getWorkcenterOee(ProductionIncomingDto productionIncomingDto) {
		// TODO Auto-generated method stub
	//	UnitEntity unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());
		
		UnitEntity unitEntity = new UnitEntity();
		if(!productionIncomingDto.getUnitid().equalsIgnoreCase("0")){
			 unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());		
		}
		
		WorkcenterEntity wsEntity = new WorkcenterEntity();
		if(!productionIncomingDto.getWorkcenterid().equalsIgnoreCase("0")){
		 wsEntity = wsService.getActiveWorkcenterByID(productionIncomingDto.getWorkcenterid());		
		}
		List<ProductWorkcenteroeeSummaryResponseRecord> prodEntityList = new ArrayList<ProductWorkcenteroeeSummaryResponseRecord>();
		//List<ProductionEntity> prodEntityList = productionRepository.getWorkcenterOee(unitEntity.getId(),wsEntity.getId(),productionIncomingDto.getFromdate(),productionIncomingDto.getTodate(),"N");
		
		List<ProductWorkcenteroeeSummaryRecord> productWorkcenteroeeSummaryRecords = productionRepository.findProductSummaries( unitEntity.getId() , wsEntity.getId() );
		
		for(ProductWorkcenteroeeSummaryRecord ProductWorkcenteroeeSummaryRecord : productWorkcenteroeeSummaryRecords) {
			
			prodEntityList.add(new ProductWorkcenteroeeSummaryResponseRecord(ProductWorkcenteroeeSummaryRecord.unitentity().getName(),ProductWorkcenteroeeSummaryRecord.workcenterentity().getName()
					,ProductWorkcenteroeeSummaryRecord.stationEntity().getName(),ProductWorkcenteroeeSummaryRecord.shiftEntity().getName(),ProductWorkcenteroeeSummaryRecord.totalQuantity()));
			
		}
		
		return prodEntityList;
	}
	
	
	@Override
	public List<ProductWorkcenterUnitWiseOeeReportRecord> getUnitOee(ProductionIncomingDto productionIncomingDto) {
		// TODO Auto-generated method stub
		//UnitEntity unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());
		
		UnitEntity unitEntity = new UnitEntity();
		if(!productionIncomingDto.getUnitid().equalsIgnoreCase("0")){
			 unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());		
		}
		
	//	List<ProductionEntity> prodEntityList = productionRepository.getUnitOee(unitEntity.getId(),productionIncomingDto.getFromdate(),productionIncomingDto.getTodate(),"N");
		
		List<ProductWorkcenterUnitWiseOeeReportRecord> productWorkcenterUnitWiseOeeReports 
	//	= productionRepository.getProductWorkcenterUnitWiseOeeReport();
		= productionRepository.getProductWorkcenterUnitWiseOeeReport(unitEntity.getId(),productionIncomingDto.getFromdate(),productionIncomingDto.getTodate(),"N");
		
		return productWorkcenterUnitWiseOeeReports;
	}

	@Override
	public List<ProductionLossSummaryRecord> getLossSummary(ProductionIncomingDto productionIncomingDto) 
	{
		// TODO Auto-generated method stub
//		UnitEntity unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());
		UnitEntity unitEntity = new UnitEntity();
		if(!productionIncomingDto.getUnitid().equalsIgnoreCase("0")){
			 unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());		
		}
		WorkcenterEntity wsEntity = new WorkcenterEntity();
		if(!productionIncomingDto.getWorkcenterid().equalsIgnoreCase("0")){
		 wsEntity = wsService.getActiveWorkcenterByID(productionIncomingDto.getWorkcenterid());		
		}
	
		
		List<ProductionLossSummaryRecord> reportList = productionRepository.getProductionLossSummaryRecord(unitEntity.getId(),wsEntity.getId(),productionIncomingDto.getFromdate(),productionIncomingDto.getTodate(),"N"); 
		
//		List<ProductionLossSummaryRecord> reportList= productionRepository.getProductionLossSummaryRecord(unitEntity.getId(),wsEntity.getId(),productionIncomingDto.getFromdate(),productionIncomingDto.getTodate(),"N");
		
		return reportList;
		//return ProductionMapper.toProductionDtoList(prodEntityList);	
		}

	@Override
	public List<Map<String, String>> getTotalProdReport(ProductionIncomingDto productionIncomingDto) {
		// TODO Auto-generated method stub
		//UnitEntity unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());
		
		UnitEntity unitEntity = new UnitEntity();
		if(!productionIncomingDto.getUnitid().equalsIgnoreCase("0")){
			 unitEntity  = unitService.getActiveEntityById(productionIncomingDto.getUnitid());		
		}
		
		List<Map<String, String>> repEntity = productionRepository.getTotalProdReport(unitEntity.getId(),productionIncomingDto.getFromdate(),productionIncomingDto.getTodate(),"N");
		
		return repEntity;
		
	}
}
