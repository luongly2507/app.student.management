package com.app.management.student.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.SubjectMapper;
import com.app.management.student.payloads.requests.CreateSubjectRequest;
import com.app.management.student.payloads.requests.UpdateSubjectRequest;
import com.app.management.student.payloads.responses.SubjectResponse;
import com.app.management.student.repositories.SubjectRepository;
import com.app.management.student.services.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SubjectMapper subjectMapper;
    
    @Override
    public List<SubjectResponse> findAll(Pageable pageable) {
        return subjectRepository
                .findAll(pageable)
                .map(clazz->subjectMapper.toSubjectResponse(clazz))
                .toList();
    }

    @Override
    public SubjectResponse findById(int id) {
        return subjectMapper.toSubjectResponse(
            subjectRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tìm thấy khối này!")));
    }

    @Override
    public SubjectResponse create(CreateSubjectRequest createSubjectRequest) {
        return subjectMapper.toSubjectResponse(
            subjectRepository.save(subjectMapper.toSubject(createSubjectRequest)
        ));
    }

    @Override
    public void delete(int id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void update(int id, UpdateSubjectRequest updateSubjectRequest) {
        subjectRepository.save(subjectMapper.toSubject(id,updateSubjectRequest));

    }

    @Override
    public long count() {
        return  subjectRepository.count();
    }

    
}
