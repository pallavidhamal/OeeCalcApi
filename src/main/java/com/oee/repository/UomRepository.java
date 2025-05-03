package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.UomEntity;

@Repository
public interface UomRepository extends JpaRepository<UomEntity, String> {

	List<UomEntity> findByIsdeleted(String string);

}
