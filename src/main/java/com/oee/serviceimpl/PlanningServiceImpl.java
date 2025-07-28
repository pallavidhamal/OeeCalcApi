package com.oee.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.PlanningDto;
import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.dto.mapper.PlanningMapper;
import com.oee.entity.PlanningEntity;
import com.oee.entity.ShiftEntity;
import com.oee.entity.StationEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.PlanningRepository;
import com.oee.repository.ShiftRepository;
import com.oee.repository.UnitRepository;
import com.oee.repository.WorkcenterRepository;
import com.oee.service.ItemService;
import com.oee.service.PlanningService;
import com.oee.service.PlanningShiftWorkService;
import com.oee.service.ShiftService;
import com.oee.service.StationService;
import com.oee.service.UnitService;
import com.oee.service.WorkcenterService;
import com.oee.util.AuthenticationService;

@Service
public class PlanningServiceImpl implements PlanningService {

	PlanningRepository planningRepository;
	ItemService itemService;
	UnitService unitService;
	ShiftService shiftService;
	WorkcenterService wsService;
	StationService stationService;
	PlanningShiftWorkService planningShiftWorkService;
	
	
	public PlanningServiceImpl (PlanningRepository planningRepository,ItemService itemService 
			, UnitService unitService ,ShiftService shiftService ,WorkcenterService wsService,StationService stationService , PlanningShiftWorkService planningShiftWorkService ) {
		
		this.planningRepository = planningRepository;
		this.itemService = itemService;
		this.unitService = unitService;
		this.shiftService = shiftService;
		this.wsService = wsService;
		this.stationService = stationService;
		this.planningShiftWorkService = planningShiftWorkService;
	}

	private static final Logger logger = LoggerFactory.getLogger(PlanningServiceImpl.class);

	@Override
	public List<PlanningDto> getAllPlannings() {

		// TODO Auto-generated method stub
		// logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");

		List<PlanningEntity> planningEntityList = planningRepository.findAll();

		if (planningEntityList == null) {
			throw BRSException.throwException("Planning List does not exist");
		}
		return PlanningMapper.toOnlyPlanningDtoList(planningEntityList);

	}

	
	@Override
	public List<PlanningDto> getAllPlanningsWDetails() {

		// TODO Auto-generated method stub
		// logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");

		List<PlanningEntity> planningEntityList = planningRepository.findAll();

		if (planningEntityList == null) {
			throw BRSException.throwException("Planning List does not exist");
		}
		return PlanningMapper.toPlanningDtoList(planningEntityList);

	}
	
	@Override
	public PlanningDto getPlanningByID(String planningID) {
		// TODO Auto-generated method stub

	//	PlanningEntity planningEntity = planningRepository.findById(planningID).get();
		
		
		PlanningEntity planningEntity = planningRepository.findByIdAndPlanningsiftworkentities_Isdeleted(planningID,"N");

		


		if (planningEntity == null) {
			throw BRSException.throwException("Planning Details does not exist.");
		}

		return PlanningMapper.toPlanningDto(planningEntity);
	}

	@Override
	public boolean addPlanning(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub

		
		
		String fromdt=planningIncomingDto.getFromdate();
		String todt=planningIncomingDto.getTodate();

		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDate dateFrom = LocalDate.parse(fromdt, formatter);
         
         LocalDate dateTo = LocalDate.parse(todt, formatter);
         LocalDate dateCur=dateFrom;
         
         while (dateCur.isBefore(dateTo.plusDays(1))) {
        	 
        	PlanningEntity planningEntity = new PlanningEntity();
        	 
        	
        	planningEntity.setUnitentity(unitService.getEntityById(planningIncomingDto.getUnitid()));
     		planningEntity.setWorkcenterentity(wsService.getWorkcenterByID(planningIncomingDto.getWorkcenterid()));
        	planningEntity.setFromdate(dateCur.toString());
     		planningEntity.setTodate(dateCur.toString());
     		planningEntity.setShift(shiftService.getShiftByID(planningIncomingDto.getShiftid()));
     		planningEntity.setTimepershift(planningIncomingDto.getTimepershift());
     		planningEntity.setPlanningsiftworkentities(planningShiftWorkService.getPlanningShiftWorkEntities(planningIncomingDto.getPlanningShiftWorkIncomingDto())); 
     		planningEntity.setIsdeleted("N");
     		planningEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
     		
     		
     		
     		logger.info("--- before saving set up ----");

     		planningRepository.save(planningEntity);

     		logger.info("--- Planning Added Successfully ----");

     		logger.info("--- datecurrent ----"+dateCur);
     		dateCur=dateCur.plusDays(1);
        	 
        	 
         }
		
		
		return true;
		

	}

	
	  @Override 
	  public boolean editPlanning(PlanningIncomingDto planningIncomingDto) {
			// TODO Auto-generated method stub

			
		  	PlanningEntity planningEntity = planningRepository.findById(planningIncomingDto.getId()).get();

			if (planningEntity == null) {
				throw BRSException.throwException(EntityType.SETUP, ExceptionType.ENTITY_NOT_FOUND, planningIncomingDto.getId());

			}
		  
			/*
			
			RawMaterialEntity specsnoDuplicateCheck = rawMaterialRepository.findByRmspecsAndIsdeleted(rawMaterialIncomingDto.getRmspecs(),"N");
			
			if (specsnoDuplicateCheck != null) {
				
				logger.error("throw error that RM Specs no already exists = "+ rawMaterialIncomingDto.getRmspecs());
				throw BRSException.throwException(EntityType.RAWMATERIAL, ALREADY_EXIST, rawMaterialIncomingDto.getRmspecs());
			}
			
			*/
			
			/*String fromdt=planningIncomingDto.getFromdate();
			String todt=planningIncomingDto.getTodate();

			
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	         LocalDate dateFrom = LocalDate.parse(fromdt, formatter);
	         
	         LocalDate dateTo = LocalDate.parse(todt, formatter);
	         LocalDate dateCur=dateFrom;
	         
	         while (dateCur.isBefore(dateTo.plusDays(1))) {*/
	        	 
	        	/*
	        	
	        	
		        	planningEntity.setUnitentity(unitService.getEntityById(planningIncomingDto.getUnitid()));
		     		planningEntity.setWorkcenterentity(wsService.getWorkcenterByID(planningIncomingDto.getWorkcenterid()));
		        	planningEntity.setFromdate(dateCur.toString());
		     		planningEntity.setTodate(dateCur.toString());
		     		planningEntity.setShift(shiftService.getShiftByID(planningIncomingDto.getShiftid()));
		     		planningEntity.setTimepershift(planningIncomingDto.getTimepershift());
	     		
	     		
	     		*/
	     		
	     		planningEntity.setPlanningsiftworkentities(planningShiftWorkService.updateAndDeletePlanningShiftWorkEntities(planningIncomingDto.getPlanningShiftWorkIncomingDto(),planningIncomingDto.getPlanningShiftWorkDeleteIncomingDto() ));
	     		planningEntity.setIsdeleted("N");
	     		planningEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
	     		
	     		
	     		
	     		logger.info("--- before saving set up ----");

	     		planningRepository.save(planningEntity);

	     		logger.info("--- Planning Added Successfully ----");

	     		//logger.info("--- datecurrent ----"+ dateCur);
				/*
				 * dateCur=dateCur.plusDays(1);
				 * 
				 * }
				 */
			return true;
		}
	 

	@Override
	public boolean deletePlanning(String planningid) {
		// TODO Auto-generated method stub
		logger.info("------ delete setup -------");

		PlanningEntity planningEntity = planningRepository.findById(planningid).get();

		if (planningEntity == null) {
			throw BRSException.throwException(EntityType.SETUP, ExceptionType.ENTITY_NOT_FOUND, planningid);

		}

		planningEntity.setIsdeleted(planningEntity.getIsdeleted().equalsIgnoreCase("Y") ? "N" : "Y");
		planningEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());

		planningRepository.save(planningEntity);
		logger.info("------ planningEntity Deleted Successfully ------");

		return true;
	}

	@Override
	public List<PlanningDto> getFilterPlanningsExist(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub
		
		UnitEntity unitEntity = unitService.getEntityById(planningIncomingDto.getUnitid());
		
		ShiftEntity shiftEntity =  shiftService.getShiftByID(planningIncomingDto.getShiftid());
		
		WorkcenterEntity wsEntity = wsService.getWorkcenterByID(planningIncomingDto.getWorkcenterid());
		
		
		List<PlanningEntity>  planningEntityList = planningRepository.getFilterPlannings(unitEntity.getId(),wsEntity.getId(),planningIncomingDto.getFromdate(),planningIncomingDto.getTodate(),shiftEntity.getId(),"N");
		
		return PlanningMapper.toPlanningDtoList(planningEntityList);
	}
	
	
	@Override
	public List<PlanningDto> getFilterPlannings(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub
		
		UnitEntity unitEntity = unitService.getEntityById(planningIncomingDto.getUnitid());
		
		WorkcenterEntity wsEntity = new WorkcenterEntity();
		
		if(!planningIncomingDto.getWorkcenterid().equalsIgnoreCase("0")) {
			
			wsEntity = wsService.getWorkcenterByID(planningIncomingDto.getWorkcenterid());
		}

		ShiftEntity shiftEntity =  new ShiftEntity();
		
		if(!planningIncomingDto.getShiftid().equalsIgnoreCase("0")) {
			
			shiftEntity = shiftService.getShiftByID(planningIncomingDto.getShiftid());
		}
		
		
		List<PlanningEntity>  planningEntityList =planningRepository.getFilterPlannings(unitEntity.getId(),wsEntity.getId(),planningIncomingDto.getFromdate(),planningIncomingDto.getTodate(),shiftEntity.getId(),"N");
		
		return PlanningMapper.toPlanningDtoList(planningEntityList);
	}


	@Override
	public PlanningDto getFilterPlanEntity(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub
		
		
		UnitEntity unitEntity  = unitService.getEntityById(planningIncomingDto.getUnitid());
		
		
		ShiftEntity shiftEntity =  shiftService.getShiftByID(planningIncomingDto.getShiftid());
		
		WorkcenterEntity wsEntity = wsService.getWorkcenterByID(planningIncomingDto.getWorkcenterid());
		
		
		PlanningEntity  planningEntity =planningRepository.findByUnitentityAndWorkcenterentityAndShiftAndFromdateAndTodate(unitEntity,wsEntity,shiftEntity,planningIncomingDto.getFromdate(),planningIncomingDto.getTodate());
		
		
		return PlanningMapper.toPlanningDto(planningEntity);
		
		
	}
	
	
	@Override
	public List<Map<String, String>> getFilterPlanEntityWithGroupBy(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub
		
		
		UnitEntity unitEntity  = unitService.getActiveEntityById(planningIncomingDto.getUnitid());
		
		ShiftEntity shiftEntity  = shiftService.getActiveShiftByID(planningIncomingDto.getShiftid());
		
		WorkcenterEntity wsEntity = wsService.getActiveWorkcenterByID(planningIncomingDto.getWorkcenterid());
		
//		PlanningEntity  planningEntity =planningRepository.findByUnitentityAndWorkcenterentityAndShiftAndFromdateAndTodate(unitEntity,wsEntity,shiftEntity,planningIncomingDto.getFromdate(),planningIncomingDto.getTodate());
		
		List<Map<String, String>> quotationEntity = planningRepository.findByUnitentityAndWorkcenterentityAndShiftAndFromdateAndTodateWithGroupBy(unitEntity.getId(),wsEntity.getId(),shiftEntity.getId(),planningIncomingDto.getFromdate(),planningIncomingDto.getTodate(),"N");
		
		
		return quotationEntity;
		
		
	}



	@Override
	public PlanningEntity getPlanningEntityByID(String planningID) {
		// TODO Auto-generated method stub
		
		PlanningEntity planningEntity = planningRepository.findByIdAndPlanningsiftworkentities_Isdeleted(planningID,"N");
		return planningEntity;

	}


	@Override
	public PlanningDto getPlanningByIDAndStation(String planId, String stationId) {
		// TODO Auto-generated method stub

		
		System.out.println("getPlanningByID upar");
		
		PlanningEntity planningEntity = planningRepository.findByIdAndPlanningsiftworkentities_IsdeletedAndId(planId,"N",stationId);

		
		System.out.println("getPlanningByID niche");


		if (planningEntity == null) {
			throw BRSException.throwException("Planning Details does not exist.");
		}

		return PlanningMapper.toPlanningDto(planningEntity);
	}


	@Override
	public List<PlanningDto>  getPlanOverviewReport(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub
		
		UnitEntity unitEntity = unitService.getEntityById(planningIncomingDto.getUnitid());
		
		StationEntity stationEntity  =  new StationEntity();
		if(!planningIncomingDto.getStationid().equalsIgnoreCase("0")) {
			
			stationEntity = stationService.getStationEntityByID(planningIncomingDto.getStationid());
		}
		
		WorkcenterEntity wsEntity = new WorkcenterEntity();
		if(!planningIncomingDto.getWorkcenterid().equalsIgnoreCase("0")) {
			
			wsEntity = wsService.getWorkcenterByID(planningIncomingDto.getWorkcenterid());
		}
		
		List<PlanningEntity>  planningEntityList = planningRepository.getFilterPlanOverviewReport(unitEntity.getId(),wsEntity.getId(),planningIncomingDto.getFromdate(),planningIncomingDto.getTodate(),stationEntity.getId(),"N");
		
		return PlanningMapper.toPlanningDtoList(planningEntityList);
	}
}
