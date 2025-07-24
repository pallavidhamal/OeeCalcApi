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
public interface ReportRepository  extends JpaRepository<PlanningEntity, String> {

	

	@Query(value = " SELECT mp.id ,mp.time_per_shift,sm.name as stationname,sm.id as stationid ,mp.from_date as plandate ,"
			+ " sfm.name as shiftname , setm.name as setupname , im.itemcode as itemcode , mpsw.plannedquantity  "
			+ " FROM master_planning mp left join master_planning_shift_work mpsw "
				+ " on mp.id = mpsw.planningentity_id  left join station_master sm on mpsw.fk_station = sm.id "
				+ " left join master_shift sfm on mp.fk_shift = sfm.id  "
				+ " left join item_master im on mpsw.fk_item = im.id  "
				+ " left join set_up_master setm on mpsw.fk_setup = setm.id  "
				+ " WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
				+ " AND   ( mp.fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) "
				+ " AND   ( mpsw.fk_station = (?3)  OR ?3 IS NULL OR ?3 = '' ) "
				+ " AND   ( mp.from_date between (?4) and (?5))  "
				+ " AND   ( mp.to_date  between (?4) and (?5)) "
				+ " AND   mp.is_deleted = (?6) AND mpsw.is_deleted = (?6)   ", nativeQuery = true)
	List<Map<String, String>> getPlanOverview(String ue,String we,String se,String fromdate,String todate,String isdeleted);

	
	
	@Query(value = " SELECT mp.id ,sm.name as stationname,sm.id as stationid ,mp.proddate as proddate ,"
			+ " sfm.name as shiftname , setm.name as setupname , im.itemcode as itemcode , mpsw.qty_planned ,mpsw.qty_produced ,mp.productivity_per "
			+ " FROM production mp left join production_planning mpsw "
				+ " on mp.id = mpsw.productionentity_id  left join station_master sm on mp.fk_stationentity = sm.id "
				+ " left join master_shift sfm on mp.fk_shiftentity = sfm.id  "
				+ " left join item_master im on mpsw.fk_item = im.id  "
				+ " left join set_up_master setm on mpsw.fk_setup = setm.id  "
				+ " WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
				+ " AND   ( mp.fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) "
				+ " AND   ( mp.fk_stationentity = (?3)  OR ?3 IS NULL OR ?3 = '' ) "
				+ " AND   ( mp.proddate between (?4) and (?5))  "
			//	+ " AND   ( mp.to_date  between (?4) and (?5)) "
				+ " AND   mp.is_deleted = (?6) AND mpsw.is_deleted = (?6)   ", nativeQuery = true)
	List<Map<String, String>> getPlanVsActual(String ue,String we,String se,String fromdate,String todate,String isdeleted);

	
	
//date shift item setup qty pln
	

}


