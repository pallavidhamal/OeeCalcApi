
package com.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.UnitEntity;

@Repository
public interface UnitRepository extends JpaRepository<UnitEntity, String> {

	List<UnitEntity> findByIsdeleted(String id);

	UnitEntity findByIdAndIsdeleted(String id, String isdeleted);

}
