package com.app.studentmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Semester;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface SemesterService {
    public Page<Semester> findAll(Pageable pageable);
    public List<Semester> findAll();
    public Semester findById(int id);
    public void deleteById(int id);
    public Semester save(Semester semester);
}
