package com.oee.dto.incoming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PlanningShiftWorkIncomingDto {

	private String itemid;
	private String stationid;
	private String shiftid;
	private String setupid;
	private String setuptime ;
	private String plannedquantity ;
	private String plannedmins ;
	private String timeutilised ;

}
