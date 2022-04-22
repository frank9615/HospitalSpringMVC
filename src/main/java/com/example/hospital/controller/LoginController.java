package com.example.hospital.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/form")
public class LoginController {

    /* Restituisco la pagina di login alla semplice get */
    @GetMapping
    public String getLogin(Model model){
        return "login";
    }


    @RequestMapping
    public String geLogin(Model model) {
        model.addAttribute("message", "Message from IndexController");
        return "login";
    }
}
