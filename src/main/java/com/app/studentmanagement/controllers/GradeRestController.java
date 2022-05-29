package com.app.studentmanagement.controllers;

import com.app.studentmanagement.payload.request.UpdateGradeRequest;
import com.app.studentmanagement.payload.response.GradeResponse;
import com.app.studentmanagement.services.GradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeRestController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/grades/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public GradeResponse findGradeById(@PathVariable("id") int id) {
        return gradeService.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_PRINCIPAL')")
    @PutMapping("/grades/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public GradeResponse  updateGradeById(@PathVariable("id") int id, @RequestBody UpdateGradeRequest gradeRequest) {
        return gradeService.save(id,gradeRequest);
    }
    
    @PreAuthorize("hasRole('ROLE_PRINCIPAL')")
    @DeleteMapping("/grades/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGradeById(@PathVariable("id") int id) {
        gradeService.deleteById(id);
    }
}
