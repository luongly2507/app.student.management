package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Subject;
import com.app.studentmanagement.repositories.SubjectRepository;
import com.app.studentmanagement.services.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Page<Subject> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(int id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        subjectRepository.deleteById(id);
        
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }
    
}
