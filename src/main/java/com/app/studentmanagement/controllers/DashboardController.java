package com.app.studentmanagement.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

   
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getDashboard() {
        return "dashboard";
    }
}
