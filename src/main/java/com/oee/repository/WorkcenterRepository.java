package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.ItemEntity;
import com.oee.entity.WorkcentreEntity;

@Repository
public interface WorkcenterRepository  extends JpaRepository<WorkcentreEntity, String> {

	List<WorkcentreEntity> findByIsdeleted(String string);

}
