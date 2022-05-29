package com.app.studentmanagement.controllers;

import com.app.studentmanagement.entities.Grade;
import com.app.studentmanagement.services.GradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;
    
    @PreAuthorize("hasRole('ROLE_PRINCIPAL')")
    @PostMapping("/grades")
    public String addSemester(@ModelAttribute Grade grade) {
        gradeService.save(grade);
        return "redirect:/";
    }
}
