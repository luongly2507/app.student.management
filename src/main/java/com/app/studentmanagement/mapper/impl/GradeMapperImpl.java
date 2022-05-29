package com.app.studentmanagement.mapper.impl;

import com.app.studentmanagement.entities.Grade;
import com.app.studentmanagement.mapper.GradeMapper;
import com.app.studentmanagement.payload.request.UpdateGradeRequest;
import com.app.studentmanagement.payload.response.GradeResponse;
import com.app.studentmanagement.repositories.GradeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GradeMapperImpl implements GradeMapper{

    @Autowired
    GradeRepository gradeRepository;
    
    @Override
    public GradeResponse toGradeResponse(Grade grade) {
        return GradeResponse.builder()
                    .id(grade.getId())
                    .name(grade.getName())
                    .build();
    }

    @Override
    public Grade toGrade(int id, UpdateGradeRequest request) {
        Grade grade = gradeRepository.findById(id).get();
        grade.setName(request.getName());
        return grade;
    }
    
}
