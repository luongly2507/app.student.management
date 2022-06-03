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
public class CreateStudentRequest {
    private String name;
    private String email;
    private LocalDate birthday;
    private int classId;
    private int semesterId;
    private String gender;
    private String address;
    
}
