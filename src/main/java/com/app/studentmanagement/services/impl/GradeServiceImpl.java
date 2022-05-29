package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Grade;
import com.app.studentmanagement.mapper.GradeMapper;
import com.app.studentmanagement.payload.request.UpdateGradeRequest;
import com.app.studentmanagement.payload.response.GradeResponse;
import com.app.studentmanagement.repositories.GradeRepository;
import com.app.studentmanagement.services.GradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GradeServiceImpl implements GradeService{

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    GradeMapper gradeMapper;

    @Override
    public List<GradeResponse> findAll() {
        return gradeRepository.findAll().stream().map(grade -> gradeMapper.toGradeResponse(grade)).toList();
    }

    @Override
    public GradeResponse findById(int id) {
        return gradeMapper.toGradeResponse(gradeRepository.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        gradeRepository.deleteById(id);
        
    }

    @Override
    public GradeResponse save(Grade grade) {
        return gradeMapper.toGradeResponse(gradeRepository.save(grade));
    }

    @Override
    public GradeResponse save(int id, UpdateGradeRequest gradeRequest) {
        return gradeMapper.toGradeResponse(gradeMapper.toGrade(id, gradeRequest));
    }

   
    
}
