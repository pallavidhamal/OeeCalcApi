package com.oee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanningShiftWorkDto {
	
	
	private String id;
	private String setuptime ;
	private String plannedquantity ;
	private String plannedmins ;
	private String timeutilised ;
	private String isdeleted;
	
	
	private String itemid;
	private String itemname;
	private String shiftid;
	private String shiftname;
	private String stationid;
	private String stationname;
	private String setupid;
	private String setupname;

	


	
	

	
}
