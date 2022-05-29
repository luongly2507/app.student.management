package com.app.studentmanagement.controllers;

import java.util.List;

import com.app.studentmanagement.payload.request.UpdateSemesterRequest;
import com.app.studentmanagement.payload.response.SemesterResponse;
import com.app.studentmanagement.services.SemesterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SemesterRestController {
    @Autowired
    private SemesterService semesterService;
    
    @GetMapping("/semesters")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SemesterResponse> findSemestersByYear(@RequestParam("search") String search) {
        if(search.isBlank()) {
            return semesterService.findAll();
        }
        return semesterService.findByYear(Integer.parseInt(search));
    }
    @GetMapping("/semesters/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public SemesterResponse findSemesterById(@PathVariable("id") int id) {
        return semesterService.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_PRINCIPAL')")
    @PutMapping("/semesters/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public SemesterResponse updateSemesterById(@PathVariable("id") int id, @RequestBody UpdateSemesterRequest semesterRequest) {
       
        return semesterService.save(id,semesterRequest);
    }
    
    @PreAuthorize("hasRole('ROLE_PRINCIPAL')")
    @DeleteMapping("/semesters/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteSemesterById(@PathVariable("id") int id) {
        semesterService.deleteById(id);
    }

}
