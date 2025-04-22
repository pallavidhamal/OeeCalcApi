package com.oee.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oee.entity.RefreshToken;
import com.oee.entity.UserInfoEntity;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken , String> {

    @Override
    Optional<RefreshToken> findById(String id);

    RefreshToken findByToken(String token);
    
    int deleteByUser(UserInfoEntity empInfoEntity);

}