package com.app.studentmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.StudentDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface StudentDetailService {
    public Page<StudentDetail> findAll(Pageable pageable);
    public List<StudentDetail> findAll();
    public StudentDetail findById(int id);
    public void deleteById(int id);
    public StudentDetail save(StudentDetail studentDetail);
}
