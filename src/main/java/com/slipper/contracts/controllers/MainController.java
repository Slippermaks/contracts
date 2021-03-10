package com.slipper.contracts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // http://localhost:8189/index

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }
}
