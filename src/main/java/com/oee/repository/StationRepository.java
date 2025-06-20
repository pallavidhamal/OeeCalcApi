package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.StationEntity;

@Repository
public interface StationRepository  extends JpaRepository<StationEntity, String> {

	List<StationEntity> findByIsdeleted(String string);

	StationEntity findByName(String name);

}
