package com.app.studentmanagement.payload.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SemesterResponse {
    private int id;
    private String name;
    private LocalDate dateEnd;
    private LocalDate dateStart;
}
