package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.ItemEntity;
import com.oee.entity.StationEntity;

@Repository
public interface ItemRepository  extends JpaRepository<ItemEntity, String> {

	ItemEntity findByItemcode(String itemcode);

	List<ItemEntity> findByIsdeleted(String string);

}
