package com.oee.dto.incoming;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PlanningIncomingDto {

	private String id;
	private String unitid;
	private String workcenterid;
	private String fromdate;
	private String todate;
	private String shiftid;
	private String timepershift;
	private String stationid;

	private List<PlanningShiftWorkIncomingDto> planningShiftWorkIncomingDto;
	private List<PlanningShiftWorkIncomingDto> planningShiftWorkDeleteIncomingDto;
	
}
