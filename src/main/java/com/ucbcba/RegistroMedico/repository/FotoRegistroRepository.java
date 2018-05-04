package com.ucbcba.RegistroMedico.repository;

import com.ucbcba.RegistroMedico.entities.FotoRegistro;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface FotoRegistroRepository extends CrudRepository<FotoRegistro,Integer> {
}
