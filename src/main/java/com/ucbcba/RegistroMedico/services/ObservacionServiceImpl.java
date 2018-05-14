package com.ucbcba.RegistroMedico.services;

import com.ucbcba.RegistroMedico.entities.Observacion;
import com.ucbcba.RegistroMedico.repository.ObservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ObservacionServiceImpl implements ObservacionService {
    private ObservacionRepository observacionRepository;

    @Autowired
    @Qualifier(value = "observacionRepository")
    public void setObservacionRepository(ObservacionRepository observacionRepository){
        this.observacionRepository = observacionRepository;
    }

    @Override
    public Iterable<Observacion> listAllObservacion() {
        return observacionRepository.findAll();
    }

    @Override
    public Observacion getObservacionById(Integer id) {
        return observacionRepository.findById(id).get();
    }

    @Override
    public Observacion saveObservacion(Observacion observacion) {
        return observacionRepository.save(observacion);
    }

    @Override
    public void deleteObservacion(Integer id) {
        observacionRepository.deleteById(id);
    }
}
