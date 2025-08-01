package com.oee.dto;

import com.oee.entity.ShiftEntity;
import com.oee.entity.StationEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;

public record ProductWorkcenteroeeSummaryRecord(UnitEntity unitentity, WorkcenterEntity workcenterentity
		,StationEntity stationEntity , ShiftEntity shiftEntity, double totalQuantity) {}


