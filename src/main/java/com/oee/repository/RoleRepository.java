package com.oee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oee.entity.RoleEntity;



@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
	
	  RoleEntity findByNamecode(String namecode);
	    
	  RoleEntity findByName(String name);
	  
	  Optional<RoleEntity> findById(String id);
	  
	  List<RoleEntity> findByStatusAndIsdeleted(String status ,String isdeleted );

	  RoleEntity getRoleById(String id);

	  List<RoleEntity> findByIdNot(String id);
	  
	  List<RoleEntity> findByIdNotAndName(String id,String name);
	  List<RoleEntity> findByIdNotAndNamecode(String id,String namecode);
}
