package com.app.management.student.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.app.management.student.payloads.requests.CreateSubjectRequest;
import com.app.management.student.payloads.requests.UpdateSubjectRequest;
import com.app.management.student.payloads.responses.SubjectResponse;

public interface SubjectService {
    public List<SubjectResponse> findAll(Pageable pageable);

    public SubjectResponse findById(int id);

    public SubjectResponse create(CreateSubjectRequest createSubjectRequest);

    public void update(int id, UpdateSubjectRequest updateSubjectRequest);

    public void delete(int id);

    public long count();
}
