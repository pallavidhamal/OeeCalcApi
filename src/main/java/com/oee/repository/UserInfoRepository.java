package com.oee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oee.entity.UserInfoEntity;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, String> {

	@Query(value = "SELECT * FROM emp_info where BINARY username = (?1)", nativeQuery = true)
	UserInfoEntity findByUsername(String username);

	Optional<UserInfoEntity> findById(String userId);
	
	UserInfoEntity getUserById(String id);

	UserInfoEntity findByMobilenumber(String mobilenumber);
	
	@Query(value = "SELECT count(id) FROM emp_info where created_at between DATE_SUB(now(), INTERVAL 7 DAY) and now();", nativeQuery = true)
	int findCountForWeekNewAddedUser();

	UserInfoEntity findByEmail(String email);
	
	List<UserInfoEntity> findByStatusAndIsdeleted(String status ,String isdeleted );
	
}
