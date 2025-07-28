package com.oee.dto.incoming;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReportIncomingDto {
	
	private String planid;
	private String shiftid;
	private String stationid;
	private String unitid;
	private String workcenterid;
	private String itemid;
	private String operatorid;
	
	private String fromdate;
	private String todate;
	


}
