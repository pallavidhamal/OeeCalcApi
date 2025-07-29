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
public class ProductionDto {

	private String id;
	private String unitid;
	private String workcenterid;
	private String isdeleted;
	private String proddate ;
	private String shiftid;
	private String shiftname;
	private String stationid;
	private String stationname;
	private String unitname;
	private String workcentername;
	private String operatorid;
	private String operatorname;
	
	private String productivityper;
	private String availabilityper;
	private String rejectionper;
	private String oeeper;
	
	private List<ProductionPlanningDto> prodPlanningDto;

	//availability
	 private String availabilitylunchtime ;
	 private String availabilityteatime ;
	 private String availabilityreviewtime ;
	 private String availabilityinpectiontime ;
	 private String availabilitymachinebreakdown ;
	 private String availabilitysetupchange ;
	 private String availabilitynomaterial ;
	 private String availabilitynolabour ;
	 private String availabilityinspection ;
	 
	 private String availabilitytooling  ;
	 private String availabilitydrawing  ;
	 private String availabilityguages  ;
	 private String availabilityotherlosses;
	 private String availabilityovertime;
	 private String availabilitytotaltime;
	 private String availabilitystdloss;
	 private String availabilityspecloss;
	 private String availabilitytotloss;
	 private String availabilitytime;
	
	
	//produ
	 private String productivitysearching;
	 private String productivitypersonnal;
	 private String productivityrework;
	 private String productivityProductionqty ;
	 private String productivitystandardqty;
	
	//quality
	 private String rejectionrejectionqty;
	 private String rejectionokqty;
	 
	 private String productivity_Production_availabletime_qty;
	 private String productivity_total_utilised_time;
	 private String achievement_per;
	 private String quality_per;
}
