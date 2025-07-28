package com.oee.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oee.entity.ItemEntity;
import com.oee.entity.ProductionEntity;

@Repository
public interface ProductionRepository   extends JpaRepository<ProductionEntity, String> {

	ProductionEntity findByIdAndProductionPlanningEntities_Isdeleted(String prodID, String string); 
	
	
	
	/*
	 * @Query(value =
	 * " SELECT mp.id ,mp.time_per_shift,sm.name as stationname,sm.id as stationid FROM master_planning mp left join master_planning_shift_work mpsw "
	 * +
	 * " on mp.id = mpsw.planningentity_id  left join station_master sm on mpsw.fk_station = sm.id  "
	 * + " WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) " +
	 * " AND   ( mp.fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) " +
	 * " AND   ( mp.fk_shift = (?3)  OR ?3 IS NULL OR ?3 = '' ) " +
	 * " AND   ( mp.from_date between (?4) and (?5))  " +
	 * " AND   ( mp.to_date  between (?4) and (?5)) " +
	 * " AND   mp.is_deleted = (?6) AND mpsw.is_deleted = (?6)  group by sm.id ;  ",
	 * nativeQuery = true)
	 */
	
	@Query(value = " SELECT mp.proddate, mu.name as unitname ,mw.name as workcentername, ms.name as shiftname, sm.name as stationname,"
			+ " sm.id as stationid ,om.name as operatorname , "
			+ " availability_per as availabilityper , productivity_per as productivityper, rejection_per as rejectionper , oee_per as oeeper  FROM "
			+ " production mp left join master_unit mu on mp.fk_unitentity = mu.id "
			+ " left join master_workcenter mw on mp.fk_workcentreentity = mw.id "
			+ " left join master_shift ms on mp.fk_shiftentity = ms.id "
			+ " left join station_master sm on mp.fk_stationentity = sm.id "
			+ " left join operator_master om on mp.fk_operatorentity = om.id	"
			+ " WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
				+ " AND   ( mp.fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) "
				+ "	 AND   ( mp.fk_shiftentity = (?3)  OR ?3 IS NULL OR ?3 = '' ) "
				+ "  AND   ( mp.fk_stationentity = (?4)  OR ?4 IS NULL OR ?4 = '' ) "
				+ "  AND   ( mp.fk_operatorentity = (?5)  OR ?5 IS NULL OR ?5 = '' ) "
				+ " AND   ( mp.proddate between (?6) and (?7))  "		
				+ " AND   mp.is_deleted = (?8) AND mp.is_deleted = (?8)  group by sm.id ", nativeQuery = true)	
	List<Map<String, String>> getFilterProductions(String ue,String wc,String shift,String station,String operator,String fromdate,String todate,String isdeleted);


	
	@Query(value = " SELECT mp.* FROM production mp left join production_planning mpsw  on mp.id = mpsw.productionentity_id  "
			+ "	WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
			+ "	AND   ( mp.fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) "
			+ "	AND   ( mp.fk_stationentity = (?3)  OR ?3 IS NULL OR ?3 = '' ) "
			+ "	AND   ( mp.proddate between (?4) and (?5)) "
			+ "	AND   mp.is_deleted = (?6) AND mpsw.is_deleted = (?6)  group by mp.id ", nativeQuery = true)	
	List<ProductionEntity> getFilterProductions(String ue, String wc, String station, String fromdate, String todate,
			String isdeleted);

	
	

}
