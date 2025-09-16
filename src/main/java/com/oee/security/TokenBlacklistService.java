package com.oee.security;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.entity.BlacklistedToken;
import com.oee.repository.BlacklistedTokenRepository;

@Service
public class TokenBlacklistService {

    @Autowired
    private BlacklistedTokenRepository repository;

    public void blacklistToken(String token, Date expiryDate) {
        BlacklistedToken blacklisted = new BlacklistedToken();
        blacklisted.setToken(token);
        blacklisted.setExpiryDate(expiryDate);
        repository.save(blacklisted);
    }

    public boolean isBlacklisted(String token) {
        return repository.existsByToken(token);
    }
}