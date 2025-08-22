package com.oee.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oee.dto.ProductWorkcenterUnitWiseOeeReportRecord;
import com.oee.dto.ProductWorkcenteroeeSummaryRecord;
import com.oee.dto.ProductionLossSummaryRecord;
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
	
	@Query(value = " SELECT mp.* FROM production mp left join production_planning mpsw  on mp.id = mpsw.productionentity_id  "
			+ "	WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
			+ "	AND   ( mp.fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) "			
			+ "	AND   ( mp.proddate between (?3) and (?4)) "
			+ "	AND   mp.is_deleted = (?5) AND mpsw.is_deleted = (?5)  group by mp.id ", nativeQuery = true)	
	List<ProductionEntity> getWorkcenterOee(String ue, String wc, String fromdate, String todate,String isdeleted);
	
	@Query(value = " SELECT mp.* FROM production mp left join production_planning mpsw  on mp.id = mpsw.productionentity_id  "
			+ "	WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
			+ "	AND   ( mp.proddate between (?2) and (?3)) "
			+ "	AND   mp.is_deleted = (?4) AND mpsw.is_deleted = (?4)  group by mp.id ", nativeQuery = true)	
	List<ProductionEntity> getUnitOee(String ue,  String fromdate, String todate,String isdeleted);
	
	/*
	 * @Query(value =
	 * " SELECT new com.oee.dto.ProductWorkcenterUnitWiseOeeReport( p.unitentity,p.workcenterentity "
	 * + " ,(( SUM(p.oee_per)/(count(p.id)*100))*100)   )FROM ProductionEntity p  "
	 * + " JOIN p.unitentity u " +
	 * " where ( u.id = :unit  OR :unit IS NULL OR :unit = '' ) " +
	 * "	AND   p.proddate between (:fromdate) and (:todate) " +
	 * "	AND   p.isdeleted = :isdeleted " +
	 * "	GROUP BY p.unitentity,p.workcenterentity")
	 * List<ProductWorkcenterUnitWiseOeeReportRecord>
	 * getProductWorkcenterUnitWiseOeeReport(@Param("unit") String unit
	 * , @Param("fromdate") String fromdate, @Param("todate") String
	 * todate, @Param("isdeleted") String isdeleted );
	 */
	
	@Query(value = " SELECT new com.oee.dto.ProductWorkcenterUnitWiseOeeReportRecord( p.unitentity.name,p.workcenterentity.name "
			+ " ,(( SUM(p.oee_per)/(count(p.id)*100))*100)   )FROM ProductionEntity p  "
			+ " JOIN p.unitentity u "
			+ " where ( u.id = :unit  OR :unit IS NULL OR :unit = '' ) "
			+ "	AND   p.proddate between (:fromdate) and (:todate) "
			+ "	AND   p.isdeleted = :isdeleted "
			+ "	GROUP BY p.unitentity,p.workcenterentity")	
	List<ProductWorkcenterUnitWiseOeeReportRecord> getProductWorkcenterUnitWiseOeeReport(@Param("unit") String unit 
			, @Param("fromdate") String fromdate,  @Param("todate") String todate,  @Param("isdeleted") String isdeleted );
	
	
	@Query(value = " SELECT sm.name as stationname, mp.id, mp.fk_stationentity,sum(mp.tot_planned_mins) as tot_planned_mins,"
			+ " sum(mp.availability_machinebreakdown) as availability_machinebreakdown, "
			+ " sum(mp.availability_setupchange) as availability_setupchange, "
			+ " sum(mp.availability_nomaterial) as availability_nomaterial,"
			+ " sum(mp.availability_nolabour) availability_nolabour, "
			+ " sum(mp.availability_inpectiontime) availability_inpectiontime,sum(mp.availability_tooling) availability_tooling, "
			+ " sum(mp.availability_drawing) availability_drawing,sum(mp.availability_guages) availability_guages, "
			+ " sum(mp.availability_otherlosses) availability_otherlosses FROM production mp "
			+ " left join station_master sm on mp.fk_stationentity = sm.id "
			+ "	WHERE ( mp.fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) "
			+ "	AND   ( mp.fk_workcentreentity = (?2)  OR ?2 IS NULL OR ?2 = '' ) "			
			+ "	AND   ( mp.proddate between (?3) and (?4)) "
			+ "	AND   mp.is_deleted = (?5)   group by mp.fk_stationentity ", nativeQuery = true)
	List<Map<String, String>> getLossSummary(String unit, String workcenter, String fromdate, String todate, String isdeleted);

	
	@Query(value = " SELECT new com.oee.dto.ProductionLossSummaryRecord(mp.stationEntity.name , mp.unitentity.name ,mp.workcenterentity.name , sum(mp.tot_planned_mins),"
			+ " sum(mp.availability_machinebreakdown), sum(mp.availability_setupchange), sum(mp.availability_nomaterial),"
			+ " sum(mp.availability_nolabour), sum(mp.availability_inpectiontime) ,sum(mp.availability_tooling) , "
			+ " sum(mp.availability_drawing) ,sum(mp.availability_guages) , "
			+ " sum(mp.availability_otherlosses)) FROM ProductionEntity mp "
			+ " JOIN mp.unitentity u "
			+ " JOIN mp.workcenterentity w "
			+ " JOIN mp.stationEntity s "
			+ " where ( u.id = :unit  OR :unit IS NULL OR :unit = '' ) "
			+ " AND   ( w.id = :workcenter  OR :workcenter IS NULL OR :workcenter = '' )  " 
			+ "	AND   mp.proddate between (:fromdate) and (:todate) "
			+ "	AND   mp.isdeleted = :isdeleted group by mp.stationEntity ")
	List<ProductionLossSummaryRecord> getProductionLossSummaryRecord(String unit, String workcenter, String fromdate, String todate, String isdeleted);
	
	
	
	@Query("SELECT new com.oee.dto.ProductWorkcenteroeeSummaryRecord(p.unitentity,p.workcenterentity,p.stationEntity,p.shiftEntity,(SUM(p.oee_per)/count(p.oee_per))) FROM ProductionEntity p "
			+ " JOIN p.unitentity u "
			+ " JOIN p.workcenterentity w "
			+ " where ( u.id = :unit  OR :unit IS NULL OR :unit = '' ) "
			+ " AND ( w.id = :workcenter  OR :workcenter IS NULL OR :workcenter = '' )  "
			+ "	GROUP BY p.unitentity,p.workcenterentity,p.stationEntity,p.shiftEntity")
    List<ProductWorkcenteroeeSummaryRecord> findProductSummaries( @Param("unit") String unit ,  @Param("workcenter") String workcenter );
	

}
