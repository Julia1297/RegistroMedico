package com.ucbcba.RegistroMedico.controllers;


import com.ucbcba.RegistroMedico.entities.RegistroMedico;
import com.ucbcba.RegistroMedico.services.RegistroMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistroMedicoController {
    private RegistroMedicoService registroMedicoService;

    @Autowired
    public void setRegistroMedicoService(RegistroMedicoService registroMedicoService){
        this.registroMedicoService = registroMedicoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home(Model model){
        Iterable<RegistroMedico> registroMedicoList = registroMedicoService.listAllRegistroMedico();
        model.addAttribute(registroMedicoList);
        return "home";
    }
}