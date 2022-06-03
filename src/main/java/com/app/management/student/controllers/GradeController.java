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

import com.app.management.student.payloads.requests.CreateGradeRequest;
import com.app.management.student.payloads.requests.UpdateGradeRequest;
import com.app.management.student.services.GradeService;

@RestController
@RequestMapping(value ="/api/v1/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/count")
    public ResponseEntity<?> getCountGrade(){
        return ResponseEntity.ok(gradeService.count());
    }
    
    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable){
        return ResponseEntity.ok(gradeService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(gradeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateGradeRequest createGradeRequest){
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(gradeService.create(createGradeRequest).getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody UpdateGradeRequest updateGradeRequest){
        gradeService.update(id, updateGradeRequest);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        gradeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    


}
