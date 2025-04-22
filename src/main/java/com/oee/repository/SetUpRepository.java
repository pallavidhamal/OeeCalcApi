package com.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.SetUpEntity;

@Repository
public interface SetUpRepository  extends JpaRepository<SetUpEntity, String> {

}
