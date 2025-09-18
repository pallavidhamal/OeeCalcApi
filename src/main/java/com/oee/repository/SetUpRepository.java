package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oee.entity.SetUpEntity;

@Repository
public interface SetUpRepository  extends JpaRepository<SetUpEntity, String> {

	@Query(value = "SELECT * FROM set_up_master where fk_stationentity=(?1) and fk_itementity=(?2) and is_deleted='N' ;", nativeQuery = true)
	List<SetUpEntity> getSetUpsByItemMachine(String stationid,String itemid);

	
	@Query(value = "SELECT * FROM set_up_master where fk_stationentity in (SELECT id FROM station_master where fk_workcentreentity in (SELECT id FROM master_workcenter where fk_unitentity = (?1) ) ) and is_deleted='N' ;", nativeQuery = true)
	List<SetUpEntity> findSetupByUnit(String unitid);
	
	@Query(value = "SELECT * FROM set_up_master where fk_unitentity=(?1) and fk_workcentreentity=(?2) and fk_itementity=(?3) and fk_stationentity=(?4) and name=(?5) and is_deleted='N' ;", nativeQuery = true)
	List<SetUpEntity> getSetUpsByUnitWcItemMachineName(String unitid,String wcid,String itemid,String stationid,String setupname);
	
	 
	
}
