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

import com.app.management.student.payloads.requests.CreateClassRequest;
import com.app.management.student.payloads.requests.UpdateClassRequest;
import com.app.management.student.services.ClassService;

@RestController
@RequestMapping(value ="/api/v1/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/count")
    public ResponseEntity<?> getCountClass(){
        return ResponseEntity.ok(classService.count());
    }
    
    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable){
        return ResponseEntity.ok(classService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(classService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateClassRequest createClassRequest){
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(classService.create(createClassRequest).getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody UpdateClassRequest updateClassRequest){
        classService.update(id, updateClassRequest);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        classService.delete(id);
        return ResponseEntity.noContent().build();
    }
    


}
