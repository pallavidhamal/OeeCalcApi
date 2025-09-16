package com.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oee.entity.BlacklistedToken;

public interface BlacklistedTokenRepository extends JpaRepository<BlacklistedToken, String> {
    boolean existsByToken(String token);
}