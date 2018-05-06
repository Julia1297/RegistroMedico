package com.ucbcba.RegistroMedico.controllers;



import com.ucbcba.RegistroMedico.entities.Usuario;
import com.ucbcba.RegistroMedico.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService userService;

    public void setUserService(UsuarioService userService){
        this.userService = userService;
    }


}