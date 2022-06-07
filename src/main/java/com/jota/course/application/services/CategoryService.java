package com.jota.course.application.services;

import com.jota.course.application.entities.Category;
import com.jota.course.application.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository reposiory;

    public List<Category> findAll() {
        return reposiory.findAll();
    }

    public Category findById(Long id){
       Optional<Category> obj = reposiory.findById(id);
       return obj.get();
    }
}
