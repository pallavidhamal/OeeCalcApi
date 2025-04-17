package com.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.ItemEntity;

@Repository
public interface WorkcenterRepository  extends JpaRepository<ItemEntity, String> {

}
