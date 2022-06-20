package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {
    @GetMapping("index")
    public String getindex(Model model) {
        model.addAttribute("name","eric");
        return "index";
    }
}
