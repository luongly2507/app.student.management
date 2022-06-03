package com.app.management.student.mappers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.management.student.entities.Grade;
import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.GradeMapper;
import com.app.management.student.payloads.requests.CreateGradeRequest;
import com.app.management.student.payloads.requests.UpdateGradeRequest;
import com.app.management.student.payloads.responses.GradeResponse;
import com.app.management.student.repositories.GradeRepository;

@Component
public class GradeMapperImpl  implements GradeMapper{

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public GradeResponse toGradeResponse(Grade grade) {
        if (grade == null) {
            return null;
        }
        return GradeResponse.builder()
                .id(grade.getId())
                .name(grade.getName())
                .build();
    }

    @Override
    public Grade toGrade(CreateGradeRequest createGradeRequest) {
        if (createGradeRequest == null) {
            return null;
        }
        return Grade.builder()
                .name(createGradeRequest.getName())
                .build();
    }

    @Override
    public Grade toGrade(int id, UpdateGradeRequest updateGradeRequest) {
        if (updateGradeRequest == null) {
            return null;
        }
        Grade grade = gradeRepository
            .findById(id)
            .orElseThrow(()-> new NotFoundException("Không tìm thấy khối này !"));
        grade.setName(updateGradeRequest.getName());
        return grade;
    }

}
