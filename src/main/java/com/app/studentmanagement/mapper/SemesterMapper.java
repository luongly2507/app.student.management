package com.app.studentmanagement.mapper;

import com.app.studentmanagement.entities.Semester;
import com.app.studentmanagement.payload.request.UpdateSemesterRequest;
import com.app.studentmanagement.payload.response.SemesterResponse;

public interface SemesterMapper {
    public SemesterResponse toSemesterResponse(Semester semester);
    public Semester toSemester(int id, UpdateSemesterRequest request);
}
