package com.example.baithicuoimodule3.myfirstspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String getHome(@RequestParam(name = "name", required = false, defaultValue = "Khách") String name,
                          Model model) {
        model.addAttribute("username", name);
        return "home";
    }
}