package com.oee.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.oee.repository.BlacklistedTokenRepository;

import java.util.Date;

@Component
public class CronScheduler {
	
	@Autowired
	BlacklistedTokenRepository blacklistedTokenRepository;
	
	@Scheduled(cron = "0 0 * * * ?") // every hour
	public void cleanupExpired() {
		blacklistedTokenRepository.deleteAll(
				blacklistedTokenRepository.findAll().stream()
	            .filter(t -> t.getExpiryDate().before(new Date()))
	            .toList()
	    );
	}
}