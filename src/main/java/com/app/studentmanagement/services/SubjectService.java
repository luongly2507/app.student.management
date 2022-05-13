package com.app.studentmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Subject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface SubjectService {
    public Page<Subject> findAll(Pageable pageable);
    public List<Subject> findAll();
    public Subject findById(int id);
    public void deleteById(int id);
    public Subject save(Subject subject);
}
