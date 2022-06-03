package com.app.management.student.mappers;

import com.app.management.student.entities.Grade;
import com.app.management.student.payloads.requests.CreateGradeRequest;
import com.app.management.student.payloads.requests.UpdateGradeRequest;
import com.app.management.student.payloads.responses.GradeResponse;

public interface GradeMapper {
    public GradeResponse toGradeResponse(Grade grade);
    public Grade toGrade(CreateGradeRequest createGradeRequest);
    public Grade toGrade(int id, UpdateGradeRequest updateGradeRequest);
}
