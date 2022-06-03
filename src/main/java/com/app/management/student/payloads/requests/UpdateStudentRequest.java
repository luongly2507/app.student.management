package com.app.management.student.payloads.requests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateStudentRequest {
    private String name;
    private String email;
    private LocalDate birthday;
    private String gender;
    private String address;
    private int semesterId;
    private int classId;
    private int currentSemesterId;
    private int currentClassId;
    
}
