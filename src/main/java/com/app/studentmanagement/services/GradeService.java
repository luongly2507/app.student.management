package com.app.studentmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Grade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface GradeService {
    public Page<Grade> findAll(Pageable pageable);
    public List<Grade> findAll();
    public Grade findById(int id);
    public void deleteById(int id);
    public Grade save(Grade grade);
}

