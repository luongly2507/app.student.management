package com.app.management.student.mappers;

import com.app.management.student.entities.Student;
import com.app.management.student.payloads.requests.CreateStudentRequest;
import com.app.management.student.payloads.requests.UpdateStudentRequest;
import com.app.management.student.payloads.responses.StudentResponse;

public interface StudentMapper {
    public StudentResponse toStudentResponse(Student student);
    public Student toStudent(CreateStudentRequest createStudentRequest);
    public Student toStudent(int id, UpdateStudentRequest updateStudentRequest);
}
