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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.management.student.payloads.requests.CreateSemesterRequest;
import com.app.management.student.payloads.requests.UpdateSemesterRequest;
import com.app.management.student.services.SemesterService;

@RestController
@RequestMapping(value ="/api/v1/semesters")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @GetMapping("/count")
    public ResponseEntity<?> getCountSemester(){
        return ResponseEntity.ok(semesterService.count());
    }
    
    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable){
        return ResponseEntity.ok(semesterService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(semesterService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateSemesterRequest createSemesterRequest){
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(semesterService.create(createSemesterRequest).getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody UpdateSemesterRequest updateSemesterRequest){
      
        semesterService.update(id, updateSemesterRequest);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        semesterService.delete(id);
        return ResponseEntity.noContent().build();
    }
    


}
