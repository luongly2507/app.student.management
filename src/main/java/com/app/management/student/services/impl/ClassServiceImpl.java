package com.app.management.student.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.ClassMapper;
import com.app.management.student.payloads.requests.CreateClassRequest;
import com.app.management.student.payloads.requests.UpdateClassRequest;
import com.app.management.student.payloads.responses.ClassResponse;
import com.app.management.student.repositories.ClassRepository;
import com.app.management.student.services.ClassService;

@Service
@Transactional
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassRepository classRepository;

    @Autowired
    ClassMapper classMapper;
    
    @Override
    public List<ClassResponse> findAll(Pageable pageable) {
        return classRepository
                .findAll(pageable)
                .map(clazz->classMapper.toClassResponse(clazz))
                .toList();
    }

    @Override
    public ClassResponse findById(int id) {
        return classMapper.toClassResponse(
            classRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tìm thấy khối này!")));
    }

    @Override
    public ClassResponse create(CreateClassRequest createClassRequest) {
        return classMapper.toClassResponse(
            classRepository.save(classMapper.toClass(createClassRequest)
        ));
    }

    @Override
    public void delete(int id) {
        classRepository.deleteById(id);
    }

    @Override
    public void update(int id, UpdateClassRequest updateClassRequest) {
        classRepository.save(classMapper.toClass(id,updateClassRequest));

    }

    @Override
    public long count() {
        return  classRepository.count();
    }

    
}
