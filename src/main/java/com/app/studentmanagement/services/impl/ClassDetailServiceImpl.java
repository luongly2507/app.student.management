package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.ClassDetail;
import com.app.studentmanagement.repositories.ClassDetailRepository;
import com.app.studentmanagement.services.ClassDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClassDetailServiceImpl implements ClassDetailService{

    @Autowired
    ClassDetailRepository ClassDetailRepository;

    @Override
    public Page<ClassDetail> findAll(Pageable pageable) {
        return ClassDetailRepository.findAll(pageable);
    }

    @Override
    public List<ClassDetail> findAll() {
        return ClassDetailRepository.findAll();
    }

    @Override
    public ClassDetail findById(int id) {
        return ClassDetailRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        ClassDetailRepository.deleteById(id);

    }

    @Override
    public ClassDetail save(ClassDetail classDetail) {
        return ClassDetailRepository.save(classDetail);
    }

}
