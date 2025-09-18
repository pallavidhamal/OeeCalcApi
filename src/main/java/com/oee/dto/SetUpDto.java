package com.oee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetUpDto {
	
	private String id;
	private String name;
	private int cycletime;
	private String itemid;
	private String item;
	private String itemdesc;
	private String stationid;
	private String station;
	private String uom;
	private String isdeleted;
	private String unitid;
	private String workcenterid;
	private String unit;
	private String workcenter;
}
