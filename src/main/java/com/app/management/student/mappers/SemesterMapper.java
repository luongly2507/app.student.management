package com.app.management.student.mappers;

import com.app.management.student.entities.Semester;
import com.app.management.student.payloads.requests.CreateSemesterRequest;
import com.app.management.student.payloads.requests.UpdateSemesterRequest;
import com.app.management.student.payloads.responses.SemesterResponse;

public interface SemesterMapper {
    public SemesterResponse toSemesterResponse(Semester semester);
    public Semester toSemester(CreateSemesterRequest createSemesterRequest);
    public Semester toSemester(int id, UpdateSemesterRequest updateSemesterRequest);
}
