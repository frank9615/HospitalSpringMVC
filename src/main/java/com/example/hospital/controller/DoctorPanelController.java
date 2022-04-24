package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorPanelController {

    @GetMapping("/doctorPanel")
    public String doctorPanel(Model model) {
        return "doctor/doctorPanel";
    }
}
