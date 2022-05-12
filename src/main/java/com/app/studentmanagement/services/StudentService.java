package com.app.studentmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface StudentService {
    public Page<Student> findAll(Pageable pageable);
    public List<Student> findAll();
    public Student findById(int id);
    public void deleteById(int id);
    public Student save(Student student);
}
