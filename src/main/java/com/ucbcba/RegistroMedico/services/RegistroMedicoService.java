package com.ucbcba.RegistroMedico.services;


import com.ucbcba.RegistroMedico.entities.RegistroMedico;

public interface RegistroMedicoService {
    Iterable<RegistroMedico> listAllRegistroMedico();

    void saveRegistroMedico(RegistroMedico registroMedico);

    RegistroMedico getRegistroMedico(Integer id);

    void deleteRegistroMedico(Integer id);
}
