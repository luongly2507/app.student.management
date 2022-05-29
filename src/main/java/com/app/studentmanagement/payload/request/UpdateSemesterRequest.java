package com.app.studentmanagement.payload.request;

import java.time.LocalDate;

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
    private LocalDate dateEnd;
    private LocalDate dateStart;
}
