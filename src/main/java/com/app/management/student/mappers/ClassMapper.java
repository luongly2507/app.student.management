package com.app.management.student.mappers;

import com.app.management.student.entities.Class;
import com.app.management.student.payloads.requests.CreateClassRequest;
import com.app.management.student.payloads.requests.UpdateClassRequest;
import com.app.management.student.payloads.responses.ClassResponse;

public interface ClassMapper {
    public ClassResponse toClassResponse(Class clazz);
    public Class toClass(CreateClassRequest createClassRequest);
    public Class toClass(int id, UpdateClassRequest updateClassRequest);
}
