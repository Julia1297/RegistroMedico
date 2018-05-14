package com.ucbcba.RegistroMedico.repository;

import com.ucbcba.RegistroMedico.entities.Observacion;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ObservacionRepository extends CrudRepository<Observacion,Integer> {
}
