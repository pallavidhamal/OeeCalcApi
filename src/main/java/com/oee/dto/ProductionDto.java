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
	
}
