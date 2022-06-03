package com.app.management.student.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.SemesterMapper;
import com.app.management.student.payloads.requests.CreateSemesterRequest;
import com.app.management.student.payloads.requests.UpdateSemesterRequest;
import com.app.management.student.payloads.responses.SemesterResponse;
import com.app.management.student.repositories.SemesterRepository;
import com.app.management.student.services.SemesterService;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService{

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    SemesterMapper semesterMapper;
    
    @Override
    public List<SemesterResponse> findAll(Pageable pageable) {
        return semesterRepository
                .findAll(pageable)
                .map(semester->semesterMapper.toSemesterResponse(semester))
                .toList();
    }

    @Override
    public SemesterResponse findById(int id) {
        return semesterMapper.toSemesterResponse(
            semesterRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tìm thấy học kì này!")));
    }

    @Override
    public SemesterResponse create(CreateSemesterRequest createSemesterRequest) {
        return semesterMapper.toSemesterResponse(
            semesterRepository.save(semesterMapper.toSemester(createSemesterRequest)
        ));
    }

    @Override
    public void delete(int id) {
        semesterRepository.deleteById(id);
    }

    @Override
    public void update(int id, UpdateSemesterRequest updateSemesterRequest) {
        semesterRepository.save(semesterMapper.toSemester(id,updateSemesterRequest));

    }

    @Override
    public long count() {
        return  semesterRepository.count();
    }

    
}
