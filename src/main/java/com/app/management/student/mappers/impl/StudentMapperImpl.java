package com.app.management.student.mappers.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.management.student.entities.ClassDetail;
import com.app.management.student.entities.Student;
import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.StudentMapper;
import com.app.management.student.payloads.requests.CreateStudentRequest;
import com.app.management.student.payloads.requests.UpdateStudentRequest;
import com.app.management.student.payloads.responses.StudentResponse;
import com.app.management.student.repositories.ClassDetailRepository;
import com.app.management.student.repositories.ClassRepository;
import com.app.management.student.repositories.SemesterRepository;
import com.app.management.student.repositories.StudentRepository;

@Component
public class StudentMapperImpl implements StudentMapper {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    ClassDetailRepository classDetailRepository;

    @Autowired
    ClassRepository classRepository;

    @Override
    public StudentResponse toStudentResponse(Student student) {
        if (student == null) {
            return null;
        }
        return StudentResponse.builder()
                .id(student.getId())
                .email(student.getEmail())
                .gender(student.getGender())
                .address(student.getAddress())
                .birthday(student.getBirthday())
                .name(student.getName())
                .build();
    }

    @Override
    public Student toStudent(CreateStudentRequest createStudentRequest) {
        if (createStudentRequest == null) {
            return null;
        }
        Optional<Student> optionalStudent = studentRepository.findByEmail(createStudentRequest.getEmail());
        if (optionalStudent.isEmpty()) {
            Student student = Student.builder()
                    .name(createStudentRequest.getName())
                    .email(createStudentRequest.getEmail())
                    .gender(createStudentRequest.getGender())
                    .address(createStudentRequest.getAddress())
                    .birthday(createStudentRequest.getBirthday())
                    .build();
            student.addClassDetail(
                    ClassDetail.builder()
                            .clazz(classRepository.findById(createStudentRequest.getClassId()).get())
                            .semester(semesterRepository.findById(createStudentRequest.getSemesterId()).get())
                            .build());
            return student;
        } else{
            Student student = optionalStudent.get();
            
            student.setName(createStudentRequest.getName());
            student.setEmail(createStudentRequest.getEmail());
            student.setGender(createStudentRequest.getGender());
            student.setAddress(createStudentRequest.getAddress());
            student.setBirthday(createStudentRequest.getBirthday());
            student.addClassDetail(
                ClassDetail.builder()
                        .clazz(classRepository.findById(createStudentRequest.getClassId()).get())
                        .semester(semesterRepository.findById(createStudentRequest.getSemesterId()).get())
                        .student(student)
                        .build());
            return student;
        }

    }

    @Override
    public Student toStudent(int id, UpdateStudentRequest updateStudentRequest) {
        if (updateStudentRequest == null) {
            return null;
        }

        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy học sinh này !"));
      
        if (classDetailRepository.findBySemesterIdAndClassIdAndStudentId(updateStudentRequest.getSemesterId(), updateStudentRequest.getClassId(), id).isEmpty()) {
            classDetailRepository.deleteById(classDetailRepository.findBySemesterIdAndClassIdAndStudentId(updateStudentRequest.getCurrentSemesterId(), updateStudentRequest.getCurrentClassId(),id).get().getId());
            student.addClassDetail(
                ClassDetail.builder()
                .clazz(classRepository.findById(updateStudentRequest.getClassId()).get())
                .semester(semesterRepository.findById(updateStudentRequest.getSemesterId()).get())
                .student(student)
                .build()
            );
        } 
        student.setName(updateStudentRequest.getName());
        student.setEmail(updateStudentRequest.getEmail());
        student.setAddress(updateStudentRequest.getAddress());
        student.setBirthday(updateStudentRequest.getBirthday());
        student.setGender(updateStudentRequest.getGender());
        return student;
    }

}
