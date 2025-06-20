package com.oee.dto.incoming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PlanningShiftWorkIncomingDto {

	private String id;
	private String stationid;
	private String itemid;
	//private String shiftid;
	private String setupid;
	private String cycletime ;
	private String setuptime ;
	private String plannedquantity ;
	private String plannedmins ;
	private String itemtimeutilised ;
	private String machinetimeutilised ;

}
