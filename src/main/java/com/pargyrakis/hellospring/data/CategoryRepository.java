package com.pargyrakis.hellospring.data;

import com.pargyrakis.hellospring.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Android"),
            new Category(2, "iOS"),
            new Category(3, "Web")
    );

    public List<Category> getAllCategories() {
        return this.ALL_CATEGORIES;
    }

}
