package com.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.StationEntity;
import com.oee.entity.StationTypeEntity;

@Repository
public interface StationTypeRepository extends JpaRepository<StationTypeEntity, String> {

}
