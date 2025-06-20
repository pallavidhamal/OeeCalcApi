package com.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.PlanningShiftWorkEntity;

@Repository
public interface PlanningShiftWorkRepository  extends JpaRepository<PlanningShiftWorkEntity, String> {

	
}
