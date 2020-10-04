package com.pargyrakis.hellospring.controller;

import com.pargyrakis.hellospring.data.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FavoritesController {

    @Autowired // this is what field injection looks like
    private GifRepository gifRepository;

    @RequestMapping("/favorites")
    public String listFavorites(ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.getAllFavorites());
        return "favorites";
    }
}
