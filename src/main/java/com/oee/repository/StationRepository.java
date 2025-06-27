package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oee.entity.SetUpEntity;
import com.oee.entity.StationEntity;

@Repository
public interface StationRepository  extends JpaRepository<StationEntity, String> {

	List<StationEntity> findByIsdeleted(String string);

	StationEntity findByName(String name);
	
	@Query(value = "SELECT * FROM station_master where fk_workcentreentity =(?1) and is_deleted='N' ;", nativeQuery = true)
	List<StationEntity> getStationByWc(String wcid);
	
	
	

}
