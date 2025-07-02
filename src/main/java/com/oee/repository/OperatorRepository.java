package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.OperatorEntity;

@Repository
public interface OperatorRepository extends JpaRepository<OperatorEntity, String> {

	List<OperatorEntity> findByIsdeleted(String string);

}
