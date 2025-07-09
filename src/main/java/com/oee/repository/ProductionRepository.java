package com.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.ItemEntity;
import com.oee.entity.ProductionEntity;

@Repository
public interface ProductionRepository   extends JpaRepository<ProductionEntity, String> {

	ProductionEntity findByIdAndProductionPlanningEntities_Isdeleted(String prodID, String string); 

}
