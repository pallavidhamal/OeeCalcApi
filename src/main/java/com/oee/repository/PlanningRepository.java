package com.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.PlanningEntity;

@Repository
public interface PlanningRepository  extends JpaRepository<PlanningEntity, String> {

}
