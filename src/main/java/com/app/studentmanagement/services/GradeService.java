package com.app.studentmanagement.services;

import java.util.List;

import com.app.studentmanagement.entities.Grade;
import com.app.studentmanagement.payload.request.UpdateGradeRequest;
import com.app.studentmanagement.payload.response.GradeResponse;

public interface GradeService {
    public List<GradeResponse> findAll();
    public GradeResponse findById(int id);
    public void deleteById(int id);
    public GradeResponse save(Grade grade);
    public GradeResponse save(int id, UpdateGradeRequest gradeRequest);
}

