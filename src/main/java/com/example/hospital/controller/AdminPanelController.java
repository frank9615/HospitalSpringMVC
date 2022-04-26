package com.example.hospital.controller;


import com.example.hospital.dao.IPatientDao;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.Triage;
import com.example.hospital.entities.User;
import com.example.hospital.service.IPatientService;
import com.example.hospital.service.ITriageService;
import com.example.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ITriageService triageService;

    @Autowired
    private IPatientService patientService;

    @GetMapping("/adminPanel")
    public String adminPanel(Model model) {
        List<User> users = this.userService.getAll();
        List<Patient> patients = this.patientService.getAll();
        List<Triage> triages = this.triageService.getAll();

        model.addAttribute("users", users);
        model.addAttribute("patients", patients);
        model.addAttribute("triages", triages);

        return "admin/adminPanel";
    }
}
