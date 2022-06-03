package com.app.management.student.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.app.management.student.payloads.requests.CreateStudentRequest;
import com.app.management.student.payloads.requests.UpdateStudentRequest;
import com.app.management.student.payloads.responses.StudentResponse;

public interface StudentService {
    public List<StudentResponse> findAll(int semesterId,int  classId,Pageable pageable);
    public StudentResponse findById(int id);
    public StudentResponse create(CreateStudentRequest createStudentRequest);
    public void update(int id, UpdateStudentRequest updateStudentRequest);
    public void delete(int id);
    public long count(int semesterId,int classId);
}
