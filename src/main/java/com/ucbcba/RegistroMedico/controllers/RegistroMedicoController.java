package com.ucbcba.RegistroMedico.controllers;


import com.ucbcba.RegistroMedico.entities.RegistroMedico;
import com.ucbcba.RegistroMedico.services.RegistroMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


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
    @RequestMapping(value = "/nuevoMedicamento", method = RequestMethod.GET)
    String nuevoMedicamento(Model model){
        model.addAttribute("registro", new RegistroMedico());
        return "nuevoMedicamento";
    }
    @RequestMapping(value = "/nuevoAnalisis", method = RequestMethod.GET)
    String nuevoAnalisis(Model model){

        model.addAttribute("registro", new RegistroMedico());
        return "nuevoAnalisis";
    }
    @RequestMapping(value = "/nuevoTratamiento", method = RequestMethod.GET)
    String nuevoTratamiento(Model model){
        model.addAttribute("registro", new RegistroMedico());

        return "nuevoTratamiento";
    }
    @RequestMapping(value = "/nuevaConsuta", method = RequestMethod.GET)
    String nuevaConsulta(Model model){
        model.addAttribute("registro", new RegistroMedico());

        return "nuevaConsulta";
    }
    @RequestMapping(value = "/nuevoRegistro", method = RequestMethod.GET)
    String nuevoRegistro(Model model){
        model.addAttribute("registro", new RegistroMedico());
        return "nuevoRegistro";
    }
    @RequestMapping("/editarRegistro/{id}")
    String editarRegistro(@PathVariable  Integer id, Model model){
        model.addAttribute("registro", registroMedicoService.getRegistroMedico(id));
        return "editarRegistro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    String save(@Valid RegistroMedico registroMedico, BindingResult bindingResult){
        registroMedicoService.saveRegistroMedico(registroMedico);

        return "redirect:/";
    }

    @RequestMapping("/mostrarRegistro/{id}")
    String mostrarRegistro(@PathVariable Integer id, Model model){
        RegistroMedico registroMedico = registroMedicoService.getRegistroMedico(id);
        model.addAttribute("registroMedico",registroMedico);
        return "mostrarRegistro";
    }

}
