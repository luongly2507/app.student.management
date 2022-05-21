package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Class;
import com.app.studentmanagement.repositories.ClassRepository;
import com.app.studentmanagement.services.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassRepository ClassRepository;

    @Override
    public Page<Class> findAll(Pageable pageable) {
        return ClassRepository.findAll(pageable);
    }

    @Override
    public List<Class> findAll() {
        return ClassRepository.findAll();
    }

    @Override
    public Class findById(int id) {
        return ClassRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        ClassRepository.deleteById(id);

    }

    @Override
    public Class save(Class clazz) {
        return ClassRepository.save(clazz);
    }

}
