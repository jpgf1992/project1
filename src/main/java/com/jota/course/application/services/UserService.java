package com.jota.course.application.services;

import com.jota.course.application.entities.Usuario;
import com.jota.course.application.repositories.UserReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserReposiory reposiory;

    public List<Usuario> findAll() {
        return reposiory.findAll();
    }

    public Usuario findById(Long id){
       Optional<Usuario> obj = reposiory.findById(id);
       return obj.get();
    }
}
