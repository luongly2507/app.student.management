package com.app.management.student.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.app.management.student.payloads.requests.CreateGradeRequest;
import com.app.management.student.payloads.requests.UpdateGradeRequest;
import com.app.management.student.payloads.responses.GradeResponse;

public interface GradeService {
    public List<GradeResponse> findAll(Pageable pageable);
    public GradeResponse findById(int id);
    public GradeResponse create(CreateGradeRequest createGradeRequest);
    public void update(int id, UpdateGradeRequest updateGradeRequest);
    public void delete(int id);
    public long count();
}
