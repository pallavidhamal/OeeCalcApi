package com.oee.dto.incoming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class SetUpIncomingDto {

	private String setupid;
	private String name;
	private String itemId;
	private String stationid;
	private int cycletime;

	private String unitid;
	private String workcenterid;
}
