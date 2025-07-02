package com.oee.dto.incoming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductionPlanningIncomingDto {

	private String planid;
	private String stationid;
	private String itemid;
	private String setupid;
	private String plannedquantity ;
	private String producedquantity ;
	private String rejectedquantity ;
	
}
