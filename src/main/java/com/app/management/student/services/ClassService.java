package com.app.management.student.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.app.management.student.payloads.requests.CreateClassRequest;
import com.app.management.student.payloads.requests.UpdateClassRequest;
import com.app.management.student.payloads.responses.ClassResponse;

public interface ClassService {
    public List<ClassResponse> findAll(Pageable pageable);

    public ClassResponse findById(int id);

    public ClassResponse create(CreateClassRequest createClassRequest);

    public void update(int id, UpdateClassRequest updateClassRequest);

    public void delete(int id);

    public long count();
}
