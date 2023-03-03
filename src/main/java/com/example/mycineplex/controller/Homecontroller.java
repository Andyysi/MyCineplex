package com.example.mycineplex.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Homecontroller {
    @GetMapping("/")
    public String Index (Model model){
        model.addAttribute("classname", "FRESH DEVELOPER");
        return "index";

    }
}
