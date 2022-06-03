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

import com.app.management.student.payloads.requests.CreateScoreRequest;
import com.app.management.student.payloads.requests.UpdateScoreRequest;
import com.app.management.student.services.ScoreService;

@RestController
@RequestMapping(value ="/api/v1/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/count")
    public ResponseEntity<?> getCountScore(){
        return ResponseEntity.ok(scoreService.count());
    }
    
    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable){
        return ResponseEntity.ok(scoreService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(scoreService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateScoreRequest createScoreRequest){
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(scoreService.create(createScoreRequest).getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody UpdateScoreRequest updateScoreRequest){
        scoreService.update(id, updateScoreRequest);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        scoreService.delete(id);
        return ResponseEntity.noContent().build();
    }
    


}
