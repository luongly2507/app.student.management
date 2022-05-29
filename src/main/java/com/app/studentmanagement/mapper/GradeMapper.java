package com.app.studentmanagement.mapper;

import com.app.studentmanagement.entities.Grade;
import com.app.studentmanagement.payload.request.UpdateGradeRequest;
import com.app.studentmanagement.payload.response.GradeResponse;

public interface GradeMapper {
    public GradeResponse toGradeResponse(Grade grade);
    public Grade toGrade(int id, UpdateGradeRequest request);


}
