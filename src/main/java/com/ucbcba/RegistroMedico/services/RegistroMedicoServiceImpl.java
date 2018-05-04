package com.ucbcba.RegistroMedico.services;

import com.ucbcba.RegistroMedico.entities.RegistroMedico;
import com.ucbcba.RegistroMedico.repository.RegistroMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RegistroMedicoServiceImpl implements RegistroMedicoService {

    private RegistroMedicoRepository registroMedicoRepository;

    @Autowired
    @Qualifier(value = "registroMedicoRepository")
    public void setRegistroMedicoRepository(RegistroMedicoRepository registroMedicoRepository) { this.registroMedicoRepository = registroMedicoRepository; }

    @Override
    public Iterable<RegistroMedico> listAllRegistroMedico() {
        return registroMedicoRepository.findAll();
    }

    @Override
    public void saveRegistroMedico(RegistroMedico registroMedico) {
        registroMedicoRepository.save(registroMedico);
    }

    @Override
    public RegistroMedico getRegistroMedico(Integer id) {
        return registroMedicoRepository.findById(id).get();
    }

    @Override
    public void deleteRegistroMedico(Integer id) {
        registroMedicoRepository.deleteById(id);
    }
}
