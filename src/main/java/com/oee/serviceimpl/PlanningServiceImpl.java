package com.oee.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.PlanningDto;
import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.dto.mapper.PlanningMapper;
import com.oee.entity.PlanningEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.PlanningRepository;
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

	@Autowired
	PlanningRepository planningRepository;

	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	WorkcenterRepository wsRepository;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	ShiftService shiftService;
	
	@Autowired
	WorkcenterService wsService;

	@Autowired
	StationService stationService;
	
	@Autowired
	PlanningShiftWorkService planningShiftWorkService;

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
		
		System.out.println("getPlanningByID upar");
		
		PlanningEntity planningEntity = planningRepository.findByIdAndPlanningSiftWorkEntities_Isdeleted(planningID,"N");

		
		System.out.println("getPlanningByID niche");


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
     		planningEntity.setPlanningSiftWorkEntities(planningShiftWorkService.getPlanningShiftWorkEntities(planningIncomingDto.getPlanningShiftWorkIncomingDto()));
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
	     		
	     		planningEntity.setPlanningSiftWorkEntities(planningShiftWorkService.updateAndDeletePlanningShiftWorkEntities(planningIncomingDto.getPlanningShiftWorkIncomingDto(),planningIncomingDto.getPlanningShiftWorkDeleteIncomingDto() ));
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
	/*
	 * @Override public List<PlanningDto>
	 * getPlanningsByItemMachine(PlanningIncomingDto planningIncomingDto) { // TODO
	 * Auto-generated method stub
	 * 
	 * List<PlanningEntity> planningEntityList =
	 * planningRepository.getPlanningsByItemMachine(planningIncomingDto.getStationId
	 * (),planningIncomingDto.getItemId());
	 * 
	 * if (shiftEntityList == null) { throw
	 * BRSException.throwException("Shift Details does not exist."); }
	 * 
	 * return ShiftMapper.toShiftDtoList(shiftEntityList);
	 * 
	 * }
	 * 
	 * return null; }
	 */


	@Override
	public List<PlanningDto> getFilterPlannings(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub
		
		UnitEntity unitEntity = new UnitEntity();
		unitEntity  = unitRepository.findById(planningIncomingDto.getUnitid()).get();
		
		WorkcenterEntity wsEntity = new WorkcenterEntity();
		
		logger.info("------ ws id -------"+planningIncomingDto.getWorkcenterid());
		
		if((planningIncomingDto.getWorkcenterid()!=null)&&(!planningIncomingDto.getWorkcenterid().equals("0")))
		wsEntity  = wsRepository.findById(planningIncomingDto.getWorkcenterid()).get();
		
		List<PlanningEntity>  planningEntityList =planningRepository.getFilterPlannings(unitEntity.getId(),wsEntity.getId(),planningIncomingDto.getFromdate(),planningIncomingDto.getTodate());
		
		return PlanningMapper.toPlanningDtoList(planningEntityList);
	}
}
