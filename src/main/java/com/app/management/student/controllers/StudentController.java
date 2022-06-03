package com.app.management.student.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.management.student.payloads.requests.CreateStudentRequest;
import com.app.management.student.payloads.requests.UpdateStudentRequest;
import com.app.management.student.services.StudentService;

@RestController
@RequestMapping(value ="/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/count")
    public ResponseEntity<?> getCountStudent(@RequestParam int semesterId, @RequestParam int classId){
        return ResponseEntity.ok(studentService.count(semesterId, classId));
    }
    
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam int semesterId, @RequestParam int classId, Pageable pageable){
        return ResponseEntity.ok(studentService.findAll(semesterId, classId,pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateStudentRequest createStudentRequest){
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(studentService.create(createStudentRequest).getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody UpdateStudentRequest updateStudentRequest){
        System.out.println(updateStudentRequest);
        studentService.update(id, updateStudentRequest);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    


}
