package com.app.management.student.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.GradeMapper;
import com.app.management.student.payloads.requests.CreateGradeRequest;
import com.app.management.student.payloads.requests.UpdateGradeRequest;
import com.app.management.student.payloads.responses.GradeResponse;
import com.app.management.student.repositories.GradeRepository;
import com.app.management.student.services.GradeService;

@Service
@Transactional
public class GradeServiceImpl implements GradeService{

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    GradeMapper gradeMapper;
    
    @Override
    public List<GradeResponse> findAll(Pageable pageable) {
        return gradeRepository
                .findAll(pageable)
                .map(grade->gradeMapper.toGradeResponse(grade))
                .toList();
    }

    @Override
    public GradeResponse findById(int id) {
        return gradeMapper.toGradeResponse(
            gradeRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tìm thấy khối này!")));
    }

    @Override
    public GradeResponse create(CreateGradeRequest createGradeRequest) {
        return gradeMapper.toGradeResponse(
            gradeRepository.save(gradeMapper.toGrade(createGradeRequest)
        ));
    }

    @Override
    public void delete(int id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public void update(int id, UpdateGradeRequest updateGradeRequest) {
        gradeRepository.save(gradeMapper.toGrade(id,updateGradeRequest));

    }

    @Override
    public long count() {
        return  gradeRepository.count();
    }

    
}
