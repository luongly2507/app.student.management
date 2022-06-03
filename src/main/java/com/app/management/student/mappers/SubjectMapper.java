package com.app.management.student.mappers;

import com.app.management.student.entities.Subject;
import com.app.management.student.payloads.requests.CreateSubjectRequest;
import com.app.management.student.payloads.requests.UpdateSubjectRequest;
import com.app.management.student.payloads.responses.SubjectResponse;

public interface SubjectMapper {
    public SubjectResponse toSubjectResponse(Subject subject);
    public Subject toSubject(CreateSubjectRequest createSubjectRequest);
    public Subject toSubject(int id, UpdateSubjectRequest updateSubjectRequest);
}
