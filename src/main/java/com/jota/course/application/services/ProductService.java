package com.jota.course.application.services;

import com.jota.course.application.entities.Category;
import com.jota.course.application.entities.Product;
import com.jota.course.application.repositories.CategoryRepository;
import com.jota.course.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository reposiory;

    public List<Product> findAll() {
        return reposiory.findAll();
    }

    public Product findById(Long id){
       Optional<Product> obj = reposiory.findById(id);
       return obj.get();
    }
}
