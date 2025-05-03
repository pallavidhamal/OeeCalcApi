package com.oee.dto.mapper;
import java.util.ArrayList;
import java.util.List;

import com.oee.dto.CompanyDto;
import com.oee.entity.CompanyEntity;

public class CompanyMapper {

	public static CompanyDto toCompanyDto(CompanyEntity companyEntity) {
		return new CompanyDto()
				.setId(companyEntity.getId())
				.setName(companyEntity.getName());
				
	}
	
	public static List<CompanyDto> toCompanyDtoList(List<CompanyEntity> CompanyEntityList) {
		List<CompanyDto> CompanyDtos = new ArrayList<CompanyDto>();
		
		for(CompanyEntity CompanyEntity : CompanyEntityList) {
			CompanyDtos.add(toCompanyDto(CompanyEntity));
		}
		
		return CompanyDtos;
	}
	
}