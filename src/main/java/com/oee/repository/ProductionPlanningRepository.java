package com.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.ProductionPlanningEntity;

@Repository
public interface ProductionPlanningRepository  extends JpaRepository<ProductionPlanningEntity, String> { 

}
