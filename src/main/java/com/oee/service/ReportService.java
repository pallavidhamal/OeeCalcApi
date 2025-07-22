package com.oee.service;

import java.util.List;
import java.util.Map;

import com.oee.dto.incoming.ReportIncomingDto;

public interface ReportService {
	

	List<Map<String, String>> getPlanOverview(ReportIncomingDto reportIncomingDto);


}
