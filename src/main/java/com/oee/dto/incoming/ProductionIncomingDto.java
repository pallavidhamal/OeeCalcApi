package com.oee.dto.incoming;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductionIncomingDto {
	
	private String planid;
	private String shiftid;
	private String stationid;
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
	 private double availability_inpectiontime ;
	 private double availability_machinebreakdown ;
	 private double availability_setupchange ;
	 private double availability_nomaterial ;
	 private double availability_nolabour ;
	 private double availability_inspection ;
	 
	 private double availability_tooling  ;
	 private double availability_drawing  ;
	 private double availability_guages  ;
	 
	 
	 private String availability_overtime;
	 private String availability_totaltime;
	 private String availability_stdloss;
	 private String availability_specloss;
	 private String availability_totloss;
	 
	 
	 private double availability_otherlosses;
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
	 private double oee_per;
	 private double tot_planned_mins;

	 private String productivity_Production_availabletime_qty;
	 private String productivity_total_utilised_time;
	 private String achievement_per;
	 private String quality_per;
	 
	 private List<ProductionPlanningIncomingDto> productionPlanningIncomingDto;


}
