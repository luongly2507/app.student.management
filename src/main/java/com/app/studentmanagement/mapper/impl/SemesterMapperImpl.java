package com.app.studentmanagement.mapper.impl;

import com.app.studentmanagement.entities.Semester;
import com.app.studentmanagement.mapper.SemesterMapper;
import com.app.studentmanagement.payload.request.UpdateSemesterRequest;
import com.app.studentmanagement.payload.response.SemesterResponse;
import com.app.studentmanagement.repositories.SemesterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SemesterMapperImpl implements SemesterMapper{

    @Autowired
    private SemesterRepository semesterRepository;
    
    @Override
    public SemesterResponse toSemesterResponse(Semester semester) {
        return SemesterResponse.builder()
                                .id(semester.getId())
                                .name(semester.getName())
                                .dateStart(semester.getDateStart())
                                .dateEnd(semester.getDateEnd())
                                .build();
    }

    @Override
    public Semester toSemester(int id, UpdateSemesterRequest request) {
        Semester semester = semesterRepository.findById(id).get();
        semester.setDateStart(request.getDateStart());
        semester.setDateEnd(request.getDateEnd());
        semester.setName(request.getName());
        return semester;
    }
    
}
