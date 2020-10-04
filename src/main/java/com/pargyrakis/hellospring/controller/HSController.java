package com.pargyrakis.hellospring.controller;

import com.pargyrakis.hellospring.data.GifRepository;
import com.pargyrakis.hellospring.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HSController {

    @Autowired  // dependency injection
    private GifRepository gifRepository;

    @RequestMapping
    public String listGifs() {
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }
}
