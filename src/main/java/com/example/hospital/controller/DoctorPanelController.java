package com.example.hospital.controller;

import com.example.hospital.config.security.SpringSecurityUserContext;
import com.example.hospital.entities.Doctor;
import com.example.hospital.service.ITriageService;
import com.example.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorPanelController {

    @Autowired
    private ITriageService triageService;

    @Autowired
    private IUserService userService;

    @GetMapping("/doctorPanel")
    public String doctorPanel(Model model) {
        String currentUser =  new SpringSecurityUserContext().getCurrentUser();
        Doctor doctor = (Doctor) userService.getDoctorByUsername(currentUser);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("triages", doctor.getTriages());

        return "doctor/doctorPanel";
    }
}
