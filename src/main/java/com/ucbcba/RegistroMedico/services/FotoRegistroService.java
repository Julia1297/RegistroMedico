package com.ucbcba.RegistroMedico.services;

import com.ucbcba.RegistroMedico.entities.FotoRegistro;

public interface FotoRegistroService {
    Iterable<FotoRegistro> listAllFotos();

    void saveFotoRegistro(FotoRegistro fotoRegistro);

    FotoRegistro getFotoRegistro(Integer id);

    void deleteFotoRegistro(Integer id);
}
