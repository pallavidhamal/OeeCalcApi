package com.oee.dto.incoming;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PlanningIncomingDto {

	private String fromdate;
	private String todate;
	private String timepershift;
	private String stationId;
	private int cycletime;
	private String unitid;
	private String workcenterid;

	private List<PlanningShiftWorkIncomingDto> planningShiftWorkIncomingDto;

	private List<PlanningStationIncomingDto> planningStationIncomingDto;
}
