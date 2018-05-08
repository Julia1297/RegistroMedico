package com.ucbcba.RegistroMedico.repository;

import com.ucbcba.RegistroMedico.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
