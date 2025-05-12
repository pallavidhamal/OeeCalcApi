package com.oee.service;

import java.util.List;

import com.oee.dto.ShiftDto;
import com.oee.entity.ShiftEntity;


public interface ShiftService {

	List<ShiftDto> getAllShifts();
	
	ShiftEntity getShiftByID(String fittingTypeID);
	
	/*
	 * boolean addShift( ShiftIncomingDto itemIncomingDto); boolean editShift(
	 * ShiftIncomingDto itemIncomingDto); boolean deleteShift(String itemid);
	 */

	ShiftDto getShiftById(String itemid);
	
	List<ShiftDto> getShiftsByUnit(String unitid);

	
}
