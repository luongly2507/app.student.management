package com.app.management.student.payloads.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SemesterResponse {
	private int id;
	private String name;
	private int yearStart;
	private int yearEnd;
}
