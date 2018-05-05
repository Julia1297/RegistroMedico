package com.ucbcba.RegistroMedico.services;

import com.ucbcba.RegistroMedico.entities.FotoRegistro;
import com.ucbcba.RegistroMedico.repository.FotoRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FotoRegistroServiceImpl implements FotoRegistroService {

    private FotoRegistroRepository fotoRegistroRepository;

    @Autowired
    @Qualifier(value = "fotoRegistroRepository")
    public void setFotoRegistroRepository(FotoRegistroRepository fotoRegistroRepository) { this.fotoRegistroRepository = fotoRegistroRepository; }

    @Override
    public Iterable<FotoRegistro> listAllFotos() {
        return fotoRegistroRepository.findAll();
    }

    @Override
    public void saveFotoRegistro(FotoRegistro fotoRegistro) {
        fotoRegistroRepository.save(fotoRegistro);
    }

    @Override
    public FotoRegistro getFotoRegistro(Integer id) {
        return fotoRegistroRepository.findById(id).get();
    }

    @Override
    public void deleteFotoRegistro(Integer id) {
        fotoRegistroRepository.deleteById(id);
    }
}
