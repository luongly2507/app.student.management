package com.app.management.student.payloads.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentResponse {
    private int id;
    private String name;
    private String email;
    private LocalDate birthday;
    private String gender;
    private String address;    
}
