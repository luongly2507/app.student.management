package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Grade;
import com.app.studentmanagement.repositories.GradeRepository;
import com.app.studentmanagement.services.GradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GradeServiceImpl implements GradeService{

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public Page<Grade> findAll(Pageable pageable) {
        return gradeRepository.findAll(pageable);
    }

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade findById(int id) {
        return gradeRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        gradeRepository.deleteById(id);
        
    }

    @Override
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }
    
}
