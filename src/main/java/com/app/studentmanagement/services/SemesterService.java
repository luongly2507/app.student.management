package com.app.studentmanagement.services;

import java.util.List;

import com.app.studentmanagement.entities.Semester;
import com.app.studentmanagement.payload.request.UpdateSemesterRequest;
import com.app.studentmanagement.payload.response.SemesterResponse;

public interface SemesterService {
    public List<SemesterResponse> findAll();
    public SemesterResponse findById(int id);
    public void deleteById(int id);
    public SemesterResponse save(Semester semester);
    public SemesterResponse save(int id,UpdateSemesterRequest semesterRequest);
    public List<SemesterResponse> findByYear(int year);
}
