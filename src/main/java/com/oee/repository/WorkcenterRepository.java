package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.WorkcenterEntity;

@Repository
public interface WorkcenterRepository  extends JpaRepository<WorkcenterEntity, String> {

	List<WorkcenterEntity> findByIsdeleted(String string);

}
