package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oee.entity.WorkcenterEntity;

@Repository
public interface WorkcenterRepository  extends JpaRepository<WorkcenterEntity, String> {

	List<WorkcenterEntity> findByIsdeleted(String string);
	
	@Query(value = "SELECT * FROM master_workcenter where fk_unitentity=(?1) and is_deleted='N' ;", nativeQuery = true)
	List<WorkcenterEntity> getWorkcenterByUnit(String unitid);

	WorkcenterEntity findByIdAndIsdeleted(String id, String isdeleted);
	
	

}
