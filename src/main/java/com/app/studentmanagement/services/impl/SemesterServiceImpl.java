package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Semester;
import com.app.studentmanagement.repositories.SemesterRepository;
import com.app.studentmanagement.services.SemesterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService{

    @Autowired
    SemesterRepository semesterRepository;

    @Override
    public Page<Semester> findAll(Pageable pageable) {
        return semesterRepository.findAll(pageable);
    }

    @Override
    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

    @Override
    public Semester findById(int id) {
        return semesterRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        semesterRepository.deleteById(id);
        
    }

    @Override
    public Semester save(Semester semester) {
        return semesterRepository.save(semester);
    }
    
}
