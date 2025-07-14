package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.PlanningEntity;
import com.oee.entity.PlanningShiftWorkEntity;
import com.oee.entity.StationEntity;

@Repository
public interface PlanningShiftWorkRepository  extends JpaRepository<PlanningShiftWorkEntity, String> {

	List<PlanningShiftWorkEntity> findByPlanningentityAndStationAndIsdeleted(PlanningEntity planEntity, StationEntity stationEntity,String isactive);

	
}
