package com.app.management.student.mappers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.management.student.entities.Semester;
import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.SemesterMapper;
import com.app.management.student.payloads.requests.CreateSemesterRequest;
import com.app.management.student.payloads.requests.UpdateSemesterRequest;
import com.app.management.student.payloads.responses.SemesterResponse;
import com.app.management.student.repositories.SemesterRepository;

@Component
public class SemesterMapperImpl  implements SemesterMapper{

    @Autowired
    SemesterRepository semesterRepository;

    @Override
    public SemesterResponse toSemesterResponse(Semester semester) {
        if (semester == null) {
            return null;
        }
        return SemesterResponse.builder()
                .id(semester.getId())
                .name(semester.getName())
                .yearStart(semester.getYearStart())
                .yearEnd(semester.getYearEnd())
                .build();
    }

    @Override
    public Semester toSemester(CreateSemesterRequest createSemesterRequest) {
        if (createSemesterRequest == null) {
            return null;
        }
        return Semester.builder()
                .name(createSemesterRequest.getName())
                .yearStart(createSemesterRequest.getYearStart())
                .yearEnd(createSemesterRequest.getYearEnd())
                .build();
    }

    @Override
    public Semester toSemester(int id, UpdateSemesterRequest updateSemesterRequest) {
        if (updateSemesterRequest == null) {
            return null;
        }
        Semester semester = semesterRepository
            .findById(id)
            .orElseThrow(()-> new NotFoundException("Không tìm thấy học kì này !"));
        semester.setName(updateSemesterRequest.getName());
        semester.setYearStart(updateSemesterRequest.getYearStart());
        semester.setYearEnd(updateSemesterRequest.getYearEnd());
        return semester;
    }

}
