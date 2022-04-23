package com.example.hospital.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    @GetMapping("/adminPanel")
    public String adminPanel() {
        return "admin/adminPanel";
    }
}
