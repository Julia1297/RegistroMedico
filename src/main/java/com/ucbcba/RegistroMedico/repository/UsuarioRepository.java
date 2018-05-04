package com.ucbcba.RegistroMedico.repository;

import com.ucbcba.RegistroMedico.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <Usuario,Integer> {
}
