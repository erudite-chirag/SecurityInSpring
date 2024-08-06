package com.example.SecurityInSpring.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AccessConrtoller {

    @GetMapping
    public String homePage(){
        return "WELCOME TO SPRING SECURITY HOME PAGE";
    }

    @GetMapping("subscriber")
    public String paidContent(){
        return "THIS CONTENT IS FOR OUR PAID USERS ONLY.";
    }

    @GetMapping("admin")
    public String adminDashboard(){
        return "WELCOME ADMIN! HERE ARE YOU SETTINGS.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("maintain")
    public String maintainPage(){
        return "MAINTENANCE HAPPENING HERE!";
    }
}
