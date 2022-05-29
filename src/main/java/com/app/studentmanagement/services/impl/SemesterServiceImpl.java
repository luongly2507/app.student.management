package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Semester;
import com.app.studentmanagement.mapper.SemesterMapper;
import com.app.studentmanagement.payload.request.UpdateSemesterRequest;
import com.app.studentmanagement.payload.response.SemesterResponse;
import com.app.studentmanagement.repositories.SemesterRepository;
import com.app.studentmanagement.services.SemesterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    SemesterMapper semesterMapper;

    @Override
    public List<SemesterResponse> findAll() {
        return semesterRepository.findAll()
                .stream()
                .map(semester -> semesterMapper.toSemesterResponse(semester))
                .toList();
    }

    @Override
    public SemesterResponse findById(int id) {
        return semesterMapper.toSemesterResponse(semesterRepository.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        semesterRepository.deleteById(id);

    }

    @Override
    public SemesterResponse save(Semester semester) {
        return semesterMapper.toSemesterResponse(semesterRepository.save(semester));
    }

    @Override
    public List<SemesterResponse> findByYear(int year) {
        return semesterRepository.findByYear(year).stream().map(semester -> semesterMapper.toSemesterResponse(semester))
                .toList();
    }

    @Override
    public SemesterResponse save(int id, UpdateSemesterRequest semesterRequest) {
        Semester newSemester = semesterMapper.toSemester(id,semesterRequest);
        return semesterMapper.toSemesterResponse(semesterRepository.save(newSemester));
    }

}
