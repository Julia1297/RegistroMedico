package com.ucbcba.RegistroMedico.services;

import com.ucbcba.RegistroMedico.entities.Usuario;
import com.ucbcba.RegistroMedico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    @Qualifier(value = "usuarioRepository")
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository; }

    @Override
    public Iterable<Usuario> listAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuario(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
