
package com.oee.service;

import java.util.List;

import com.oee.dto.UnitDto;
import com.oee.entity.UnitEntity;

public interface UnitService {

	UnitDto getById(String id);
	
	UnitEntity getEntityById(String id);
	
	UnitEntity getActiveEntityById(String id);

	List<UnitDto> get();

	List<UnitDto> getActive();

}
