package com.jota.course.application.services;

import com.jota.course.application.entities.Order;
import com.jota.course.application.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository reposiory;

    public List<Order> findAll() {
        return reposiory.findAll();
    }

    public Order findById(Long id){
       Optional<Order> obj = reposiory.findById(id);
       return obj.get();
    }
}
