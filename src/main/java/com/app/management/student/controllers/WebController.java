package com.app.management.student.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/semesters")
    public String getSemestersPage(Model model){
        model.addAttribute("title", "Quản lý học kì");
        return "semesters";
    }
    @GetMapping("/grades")
    public String getGradesPage(Model model){
        model.addAttribute("title", "Quản lý khối");
        return "grades";
    }
    @GetMapping("/classes")
    public String getClassesPage(Model model){
        model.addAttribute("title", "Quản lý lớp");
        return "classes";
    }
    @GetMapping("/students")
    public String getStudentsPage(Model model){
        model.addAttribute("title", "Quản lý học sinh");
        return "students";
    }
    @GetMapping("/subjects")
    public String getSubjectPage(Model model){
        model.addAttribute("title", "Quản lý môn học");
        return "subjects";
    }
    @GetMapping("/scores")
    public String getScorePage(Model model){
        model.addAttribute("title", "Quản lý điểm");
        return "scores";
    }
}
