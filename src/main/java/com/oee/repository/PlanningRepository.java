package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oee.entity.PlanningEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;

@Repository
public interface PlanningRepository  extends JpaRepository<PlanningEntity, String> {

	
	
	@Query(value = "SELECT * FROM master_planning WHERE ( fk_unitentity = (?1)  OR ?1 IS NULL OR ?1 = '' ) ; ", nativeQuery = true)
	List<PlanningEntity> getFilterPlannings(String unitentity);
	
}
