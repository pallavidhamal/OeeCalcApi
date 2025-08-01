package com.oee.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanningDto {
	
	private String id;
	private String unitid;
	private String workcenterid;
	private String isdeleted;
	private String fromdate ;
	private String todate ;
	private String shiftid;
	private String shiftname;
	private String timePerShift;
	private String unitname;
	private String workcentername;
	private List<PlanningShiftWorkDto> planningShiftWork;

	
	
}
