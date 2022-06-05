package com.jota.course.application.resources;

import com.jota.course.application.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping()
    public ResponseEntity<Usuario> findAll(){
        Usuario u = new Usuario(1L,"Maria","Maria@gmail.com","99999","123456");
        return ResponseEntity.ok().body(u);
    }

}
