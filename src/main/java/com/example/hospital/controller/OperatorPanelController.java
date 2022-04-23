package com.example.hospital.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operator/")
public class OperatorPanelController {

    @GetMapping("/operatorPanel")
    public String getOperatorPanel(Model model){
        return "operator/operatorPanel";
    }
}
