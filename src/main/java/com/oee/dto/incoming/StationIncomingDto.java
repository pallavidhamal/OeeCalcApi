package com.oee.dto.incoming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class StationIncomingDto {

	private String unitid;
	private String stationid;
	private String name;
	private String stationtypeid;
	private String uomid;
	private String workcenterid;


}
