package com.app.studentmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.ClassDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface ClassDetailService {
    public Page<ClassDetail> findAll(Pageable pageable);
    public List<ClassDetail> findAll();
    public ClassDetail findById(int id);
    public void deleteById(int id);
    public ClassDetail save(ClassDetail classDetail);
}
