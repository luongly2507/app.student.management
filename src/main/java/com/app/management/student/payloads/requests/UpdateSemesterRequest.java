package com.app.management.student.payloads.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSemesterRequest {
    private String name;
    private int yearStart;
    private int yearEnd;
}
