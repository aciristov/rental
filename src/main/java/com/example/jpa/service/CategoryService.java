package com.example.jpa.service;

import com.example.jpa.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Category save(Category category);

    Optional<Category> findById(Long id);

    void delete(Category category);

}
