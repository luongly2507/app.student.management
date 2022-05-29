package com.app.studentmanagement.controllers;

import com.app.studentmanagement.entities.Grade;
import com.app.studentmanagement.entities.Semester;
import com.app.studentmanagement.services.GradeService;
import com.app.studentmanagement.services.SemesterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private SemesterService semesterService;
    @Autowired
    private GradeService gradeService;
   
    @GetMapping("/")
    public String getDashboard(Model model) {
        model.addAttribute("title","Ali | Student Management");
        model.addAttribute("semesters",semesterService.findAll());
        model.addAttribute("semester",new Semester());
        model.addAttribute("grades",gradeService.findAll());
        model.addAttribute("grade",new Grade());
        return "index";
    }
}
