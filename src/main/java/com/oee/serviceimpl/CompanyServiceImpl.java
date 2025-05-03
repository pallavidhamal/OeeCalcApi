package com.oee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oee.dto.CompanyDto;
import com.oee.dto.mapper.CompanyMapper;
import com.oee.entity.CompanyEntity;
import com.oee.repository.CompanyRepository;
import com.oee.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@Override
	public CompanyDto getById(String id) {
		// TODO Auto-generated method stub
		
		Optional<CompanyEntity> companyEntity = companyRepository.findById(id);
		
		return CompanyMapper.toCompanyDto(companyEntity.get());
	}

	@Override
	public List<CompanyDto> get() {
		// TODO Auto-generated method stub
		List<CompanyEntity> companyEntities = companyRepository.findAll();
		
		return CompanyMapper.toCompanyDtoList(companyEntities);
	}

	@Override
	public List<CompanyDto> getActive() {
		// TODO Auto-generated method stub
		List<CompanyEntity> companyEntities = companyRepository.findByIsdeleted("N");
		
		return CompanyMapper.toCompanyDtoList(companyEntities);
	}

}
