package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oee.entity.ShiftEntity;

@Repository
public interface ShiftRepository  extends JpaRepository<ShiftEntity, String> {

//ShiftEntity findByItemcode(String itemcode);

	
	@Query(value = "SELECT * FROM master_shift where unitentity_id=(?1) and is_deleted='N' ;", nativeQuery = true)
	List<ShiftEntity> getShiftsByUnit(String unitid);

	ShiftEntity findByIdAndIsdeleted(String id, String isdeleted);
	
	
	
}
