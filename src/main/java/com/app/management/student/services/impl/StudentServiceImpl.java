package com.app.management.student.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.StudentMapper;
import com.app.management.student.payloads.requests.CreateStudentRequest;
import com.app.management.student.payloads.requests.UpdateStudentRequest;
import com.app.management.student.payloads.responses.StudentResponse;
import com.app.management.student.repositories.StudentRepository;
import com.app.management.student.services.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;
    
    @Override
    public List<StudentResponse> findAll(int semesterId, int classId,Pageable pageable) {
        return studentRepository
                .findBySemesterIdAndClassId(semesterId, classId, pageable)
                .map(student->studentMapper.toStudentResponse(student))
                .toList();
    }

    @Override
    public StudentResponse findById(int id) {
        return studentMapper.toStudentResponse(
            studentRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tìm thấy khối này!")));
    }

    @Override
    public StudentResponse create(CreateStudentRequest createStudentRequest) {
        return studentMapper.toStudentResponse(
            studentRepository.save(studentMapper.toStudent(createStudentRequest)
        ));
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void update(int id, UpdateStudentRequest updateStudentRequest) {
        studentRepository.save(studentMapper.toStudent(id,updateStudentRequest));

    }

    @Override
    public long count(int semesterId,int classId) {
        return  studentRepository.countBySemesterIdAndClassId(semesterId, classId);
    }

    
}
