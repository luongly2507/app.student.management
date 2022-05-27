package com.app.studentmanagement.controllers;

import javax.validation.Valid;

import com.app.studentmanagement.payload.request.UserSignUpRequest;
import com.app.studentmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/auth")
    public String getAuthPage(Model model, 
            @RequestParam(required = false) String loginError,
            @RequestParam(required = false) String registerEmailExist,
            @RequestParam(required = false) String registerSuccess) {
        if (loginError != null) {
            model.addAttribute("loginErrorMessage", "Username or password is incorrect.");
        }
        if (registerEmailExist != null) {
            model.addAttribute("registerEmailExist", "Email is already exist! Please login.");
        }
        if (registerSuccess != null) {
            model.addAttribute("registerSuccess", "Sign Up Success. Please login to use.");
        }
        model.addAttribute("userSignupRequest", new UserSignUpRequest());
        return "auth";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute @Valid UserSignUpRequest userSignUpRequest) {
        if (userService.registerUser(userSignUpRequest) == null) {
            return "redirect:/auth?registerEmailExist=true";
        } else {
            return "redirect:/auth?registerSuccess=true";
        }

    }

}
