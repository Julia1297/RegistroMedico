package com.ucbcba.RegistroMedico.controllers;

import com.ucbcba.RegistroMedico.services.FotoRegistroService;
import org.springframework.beans.factory.annotation.Autowired;

public class FotoRegistroController {
    private FotoRegistroService FotoRegistroService;

    @Autowired
    public void setFotoRegistroService(FotoRegistroService fotoRegistroService){
        this.FotoRegistroService = fotoRegistroService;
    }
}
