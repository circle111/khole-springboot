package com.circle.service;

import com.circle.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;
    @Test
    public void read() {
        System.out.println(categoryService.countCategory());

        System.out.println();
        for (Category category : categoryService.listCategory()) {
            System.out.println(category);
        }
        System.out.println();
        List<Category> categories = categoryService.listCategoryWithCount();
        for (Category category : categories) {
            System.out.println(category);
        }
    }
    @Test
    public void read1() {
        System.out.println(categoryService.getCategoryById(1));
        System.out.println(categoryService.getCategoryByName("java"));
    }
    @Test
    public void add() {
        Category category = new Category();
        category.setCategoryName("vue");
        categoryService.insertCategory(category);
    }
    @Test
    public void delete() {
        categoryService.deleteCategory(6);
    }
    @Test
    public void update() {
        Category category = new Category();
        category.setCategoryId(5);
        category.setCategoryName("vue");
        category.setCategoryPid(0);
        categoryService.updateCategory(category);
    }
}
