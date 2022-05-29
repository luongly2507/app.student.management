package com.app.studentmanagement.controllers;

import com.app.studentmanagement.entities.Semester;
import com.app.studentmanagement.services.SemesterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SemesterController {
    
    @Autowired
    private SemesterService semesterService;

    @PreAuthorize("hasRole('ROLE_PRINCIPAL')")
    @PostMapping("/semesters")
    public String addSemester(@ModelAttribute Semester semester) {
        semesterService.save(semester);
        return "redirect:/";
    }
}
