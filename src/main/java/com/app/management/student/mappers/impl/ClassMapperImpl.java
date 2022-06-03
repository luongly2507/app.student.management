package com.app.management.student.mappers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.management.student.entities.Class;
import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.ClassMapper;
import com.app.management.student.mappers.GradeMapper;
import com.app.management.student.payloads.requests.CreateClassRequest;
import com.app.management.student.payloads.requests.UpdateClassRequest;
import com.app.management.student.payloads.responses.ClassResponse;
import com.app.management.student.repositories.ClassRepository;
import com.app.management.student.repositories.GradeRepository;

@Component
public class ClassMapperImpl  implements ClassMapper{

    @Autowired
    ClassRepository clazzRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public ClassResponse toClassResponse(Class clazz) {
        if (clazz == null) {
            return null;
        }
        return ClassResponse.builder()
                .id(clazz.getId())
                .name(clazz.getName())
                .grade(gradeMapper.toGradeResponse(clazz.getGrade()))
                .build();
    }

    @Override
    public Class toClass(CreateClassRequest createClassRequest) {
        if (createClassRequest == null) {
            return null;
        }
        return Class.builder()
                .name(createClassRequest.getName())
                .grade(gradeRepository.findById(createClassRequest.getGradeId()).get())
                .build();
    }

    @Override
    public Class toClass(int id, UpdateClassRequest updateClassRequest) {
        if (updateClassRequest == null) {
            return null;
        }
        Class clazz = clazzRepository
            .findById(id)
            .orElseThrow(()-> new NotFoundException("Không tìm thấy lớp này !"));
        clazz.setName(updateClassRequest.getName());
        clazz.setGrade(gradeRepository.findById(updateClassRequest.getGradeId()).get());
        return clazz;
    }

}
