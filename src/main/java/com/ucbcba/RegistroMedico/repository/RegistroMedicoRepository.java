package com.ucbcba.RegistroMedico.repository;

import com.ucbcba.RegistroMedico.entities.RegistroMedico;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface RegistroMedicoRepository extends CrudRepository<RegistroMedico,Integer> {
}
