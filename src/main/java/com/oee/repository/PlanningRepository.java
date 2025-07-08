package com.oee.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oee.entity.PlanningEntity;
import com.oee.entity.ShiftEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;

@Repository
public interface PlanningRepository  extends JpaRepository<PlanningEntity, String> {

	
	
	@Query(value = "SELECT * FROM master_planning WHERE ( fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
			+ "  AND  ( fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) "
			+ " AND   (  from_date between (?3) and (?4))  "
			+ " AND   ( to_date  between (?3) and (?4)) ;  ", nativeQuery = true)
	List<PlanningEntity> getFilterPlannings(String unitid,String workcenterid,String seldate,String seldate1);
	
	
	List<PlanningEntity> findByPlanningsiftworkentities_Isdeleted(String isdeleted);


	PlanningEntity findByIdAndPlanningsiftworkentities_Isdeleted(String planid,String isdeleted);

	PlanningEntity findByUnitentityAndWorkcenterentityAndShiftAndFromdateAndTodate(UnitEntity ue,WorkcenterEntity we,ShiftEntity se,String fromdate,String todate);

	@Query(value = " SELECT mp.id ,mp.time_per_shift,sm.name as stationname,sm.id as stationid FROM master_planning mp left join master_planning_shift_work mpsw "
				+ "  on mp.id = mpsw.planningentity_id  left join station_master sm on mpsw.fk_station = sm.id  "
			
				+ "  WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
			+ "  AND  ( mp.fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) "
			+ "  AND  ( mp.fk_shift = (?3)  OR ?3 IS NULL OR ?3 = '' ) "
			+ " AND   ( mp.from_date between (?4) and (?5))  "
			+ " AND   ( mp.to_date  between (?4) and (?5)) group by sm.id ;  ", nativeQuery = true)
	List<Map<String, String>> findByUnitentityAndWorkcenterentityAndShiftAndFromdateAndTodateWithGroupBy(String ue,String we,String se,String fromdate,String todate);

	

	PlanningEntity findByIdAndPlanningsiftworkentities_IsdeletedAndId(String planId, String string, String stationId);
	

}


