package com.ucbcba.RegistroMedico.services;

import com.ucbcba.RegistroMedico.entities.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);

    Iterable<User> listAllUsers();
}
