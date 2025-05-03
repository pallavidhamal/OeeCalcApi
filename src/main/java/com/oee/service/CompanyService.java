package com.oee.service;

import java.util.List;

import com.oee.dto.CompanyDto;

public interface CompanyService {

	CompanyDto getById(String id);

	List<CompanyDto> get();

	List<CompanyDto> getActive();
}
