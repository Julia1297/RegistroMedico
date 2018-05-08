package com.ucbcba.RegistroMedico.services;


import com.ucbcba.RegistroMedico.entities.User;

public interface UserService {
    void saveUser(User user);

    User findByUsername(String username);
}
