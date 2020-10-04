package com.pargyrakis.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HSController {
    @RequestMapping
    public String listGifs() {
        return "home";
    }
}
