package com.app.studentmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Class;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface ClassService {
    public Page<Class> findAll(Pageable pageable);
    public List<Class> findAll();
    public Class findById(int id);
    public void deleteById(int id);
    public Class save(Class _class);
}
