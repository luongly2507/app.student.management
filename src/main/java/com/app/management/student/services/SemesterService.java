package com.app.management.student.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.app.management.student.payloads.requests.CreateSemesterRequest;
import com.app.management.student.payloads.requests.UpdateSemesterRequest;
import com.app.management.student.payloads.responses.SemesterResponse;

public interface SemesterService {
    public List<SemesterResponse> findAll(Pageable pageable);
    public SemesterResponse findById(int id);
    public SemesterResponse create(CreateSemesterRequest createSemesterRequest);
    public void update(int id, UpdateSemesterRequest updateSemesterRequest);
    public void delete(int id);
    public long count();
}
