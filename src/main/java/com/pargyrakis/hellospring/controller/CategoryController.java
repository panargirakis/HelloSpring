package com.pargyrakis.hellospring.controller;

import com.pargyrakis.hellospring.data.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/categories")
    public String categories(ModelMap modelMap) {
        modelMap.put("categories", categoryRepository.getAllCategories());
        return "categories";
    }
}
