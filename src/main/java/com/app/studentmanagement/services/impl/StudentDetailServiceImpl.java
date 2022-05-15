package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.StudentDetail;
import com.app.studentmanagement.repositories.StudentDetailRepository;
import com.app.studentmanagement.services.StudentDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentDetailServiceImpl implements StudentDetailService{

    @Autowired
    StudentRepository studentDetailRepository;

    @Override
    public Page<StudentDetail> findAll(Pageable pageable) {
        return studentDetailRepository.findAll(pageable);
    }

    @Override
    public List<StudentDetail> findAll() {
        return studentDetailRepository.findAll();
    }

    @Override
    public StudentDetail findById(int id) {
        return studentDetailRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        studentDetailRepository.deleteById(id);

    }

    @Override
    public StudentDetail save(StudentDetail studentDetail) {
        return studentDetailRepository.save(studentDetail);
    }

}
