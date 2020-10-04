package com.pargyrakis.hellospring.controller;

import com.pargyrakis.hellospring.data.CategoryRepository;
import com.pargyrakis.hellospring.data.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final GifRepository gifRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, GifRepository gifRepository) {
        this.categoryRepository = categoryRepository;
        this.gifRepository = gifRepository;
    }

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryRepository.getAllCategories());
        return "categories";
    }

    @RequestMapping("/categories/{id}")
    public String categoryDetail(@PathVariable int id, ModelMap modelMap) {
        modelMap.put("category", categoryRepository.findById(id));
        modelMap.put("gifs", gifRepository.findByCategoryId(id));
        return "category";
    }
}
