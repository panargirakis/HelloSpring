package com.pargyrakis.hellospring.controller;

import com.pargyrakis.hellospring.data.GifRepository;
import com.pargyrakis.hellospring.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HSController {
    private final GifRepository gifRepository;

    @Autowired
    public HSController(GifRepository gifRepository) {
        this.gifRepository = gifRepository;
    }

    @RequestMapping
    public String listGifs(@RequestParam(required = false) Optional<String> q, ModelMap modelMap) {
        if (q.isPresent()) {
            List<Gif> matchingGifs = gifRepository.getGifsWithSubStringInName(q.get());
            modelMap.put("gifs", matchingGifs);
        }
        else {
            modelMap.put("gifs", gifRepository.getAllGifs());
        }
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

}
