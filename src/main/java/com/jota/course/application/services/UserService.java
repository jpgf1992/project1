package com.jota.course.application.services;

import com.jota.course.application.entities.Usuario;
import com.jota.course.application.repositories.UserRepository;
import com.jota.course.application.services.Exceptions.DataBaseExeption;
import com.jota.course.application.services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
       return obj.orElseThrow(()->new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario obj){
       return reposiory.save(obj);
    }

    public void delete(Long id){
        try{
            reposiory.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseExeption(e.getMessage());
        }

    }

    public Usuario update(Long id, Usuario obj){
        Usuario entity = reposiory.getOne(id);
        updateData(entity,obj);
        return reposiory.save(entity);
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
