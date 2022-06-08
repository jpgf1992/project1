package com.jota.course.application.services;

import com.jota.course.application.entities.Usuario;
import com.jota.course.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository reposiory;

    public List<Usuario> findAll() {
        return reposiory.findAll();
    }

    public Usuario findById(Long id){
       Optional<Usuario> obj = reposiory.findById(id);
       return obj.get();
    }

    public Usuario insert(Usuario obj){
       return reposiory.save(obj);
    }

    public void delete(Long id){
        reposiory.deleteById(id);
    }
}
