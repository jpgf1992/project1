package com.jota.course.application.repositories;

import com.jota.course.application.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Long> {

}
