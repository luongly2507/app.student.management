package com.app.management.student.mappers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.management.student.entities.Subject;
import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.SubjectMapper;
import com.app.management.student.mappers.GradeMapper;
import com.app.management.student.payloads.requests.CreateSubjectRequest;
import com.app.management.student.payloads.requests.UpdateSubjectRequest;
import com.app.management.student.payloads.responses.SubjectResponse;
import com.app.management.student.repositories.SubjectRepository;
import com.app.management.student.repositories.GradeRepository;

@Component
public class SubjectMapperImpl  implements SubjectMapper{

    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public SubjectResponse toSubjectResponse(Subject subject) {
        if (subject == null) {
            return null;
        }
        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .grade(gradeMapper.toGradeResponse(subject.getGrade()))
                .build();
    }

    @Override
    public Subject toSubject(CreateSubjectRequest createSubjectRequest) {
        if (createSubjectRequest == null) {
            return null;
        }
        return Subject.builder()
                .name(createSubjectRequest.getName())
                .grade(gradeRepository.findById(createSubjectRequest.getGradeId()).get())
                .build();
    }

    @Override
    public Subject toSubject(int id, UpdateSubjectRequest updateSubjectRequest) {
        if (updateSubjectRequest == null) {
            return null;
        }
        Subject subject = subjectRepository
            .findById(id)
            .orElseThrow(()-> new NotFoundException("Không tìm thấy lớp này !"));
        subject.setName(updateSubjectRequest.getName());
        subject.setGrade(gradeRepository.findById(updateSubjectRequest.getGradeId()).get());
        return subject;
    }

}
