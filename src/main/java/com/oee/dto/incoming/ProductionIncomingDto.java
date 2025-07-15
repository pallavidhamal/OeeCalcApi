package com.oee.dto.incoming;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductionIncomingDto {
	
	
	private String shiftid;
	private String stationId;
	private String unitid;
	private String workcenterid;
	private String itemid;
	private String proddate;
	private String operatorid;
	
	private String fromdate;
	private String todate;
	
	 private String availability_lunchtime ;
	 private String availability_teatime ;
	 private String availability_reviewtime ;
	 private String availability_inpectiontime ;
	 private String availability_machinebreakdown ;
	 private String availability_setupchange ;
	 private String availability_nomaterial ;
	 private String availability_nolabour ;
	 private String availability_inspection ;
	 
	 private String availability_tooling  ;
	 private String availability_drawing  ;
	 private String availability_guages  ;
	 
	 
	 private String availability_overtime;
	 private String availability_totaltime;
	 private String availability_stdloss;
	 private String availability_specloss;
	 private String availability_totloss;
	 
	 
	 private String availability_otherlosses;
	 private String availability_calculation;
	 private String availability_time;
	 private String availability_per;
	 
	 private String productivity_searching;
	 private String productivity_personnal;
	 private String productivity_rework;
	 private String productivity_Production_qty ;
	 private String productivity_standard_qty;
	 private String productivity_per;
	 
	 private String rejection_rejection_qty;
	 private String rejection_ok_qty;
	 private String rejection_per;
	 private String oee_per;

	 
	 private List<ProductionPlanningIncomingDto> productionPlanningIncomingDto;


}
