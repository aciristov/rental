package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.Category;
import com.example.jpa.model.Post;
import com.example.jpa.repository.CategoryRepository;
import com.example.jpa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoryAPI")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/categories")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/categories/{categoryid}")
    public Category updateCategory(@PathVariable Long categoryid, @Valid @RequestBody Category categoryRequest) {
        return categoryService.findById(categoryid).map(category -> {
            category.setName(categoryRequest.getName());
            return categoryService.save(category);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + categoryid + " not found"));
    }

    @DeleteMapping("/categories/{categoryid}")
    public ResponseEntity<?> deletePost(@PathVariable Long categoryid) {
        return categoryService.findById(categoryid).map(category -> {
            categoryService.delete(category);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + categoryid + " not found"));
    }


}
