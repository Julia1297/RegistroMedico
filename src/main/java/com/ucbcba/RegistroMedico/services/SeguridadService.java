package com.ucbcba.RegistroMedico.services;

public interface SeguridadService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
