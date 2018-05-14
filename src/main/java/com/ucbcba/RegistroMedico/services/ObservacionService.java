package com.ucbcba.RegistroMedico.services;

import com.ucbcba.RegistroMedico.entities.Observacion;

public interface ObservacionService {
    Iterable<Observacion> listAllObservacion();

    Observacion getObservacionById(Integer id);

    Observacion saveObservacion(Observacion observacion);

    void deleteObservacion(Integer id);
}
