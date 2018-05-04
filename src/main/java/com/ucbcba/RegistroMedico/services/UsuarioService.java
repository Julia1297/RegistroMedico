package com.ucbcba.RegistroMedico.services;


import com.ucbcba.RegistroMedico.entities.Usuario;

public interface UsuarioService {
    Iterable<Usuario> listAllUsuario();

    void saveUsuario(Usuario usuario);

    Usuario getUsuario(Integer id);

    void deleteUsuario(Integer id);
}
