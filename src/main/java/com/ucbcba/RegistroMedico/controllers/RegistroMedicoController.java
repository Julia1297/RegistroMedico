package com.ucbcba.RegistroMedico.controllers;


import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ucbcba.RegistroMedico.entities.FotoRegistro;
import com.ucbcba.RegistroMedico.entities.Observacion;
import com.ucbcba.RegistroMedico.entities.RegistroMedico;
import com.ucbcba.RegistroMedico.services.FotoRegistroService;
import com.ucbcba.RegistroMedico.services.ObservacionService;
import com.ucbcba.RegistroMedico.services.RegistroMedicoService;
import com.ucbcba.RegistroMedico.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
public class RegistroMedicoController {
    private UserService userService;
    private RegistroMedicoService registroMedicoService;
    private FotoRegistroService fotoRegistroService;
    private ObservacionService observacionService;
    private RegistroMedico reg;

    @Autowired
    public void setObservacionService(ObservacionService observacionService){
        this.observacionService = observacionService;
    }

    @Autowired
    public void setFotoRegistroService(FotoRegistroService fotoRegistroService){
        this.fotoRegistroService = fotoRegistroService;
    }

    @Autowired
    public void setRegistroMedicoService(RegistroMedicoService registroMedicoService){
        this.registroMedicoService = registroMedicoService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home(Model model){
        Iterable<RegistroMedico> registroMedicoList = registroMedicoService.listAllRegistroMedico();
        model.addAttribute(registroMedicoList);
        return "redirect:/miHistorial";
    }
    @RequestMapping(value = "/miHistorial", method = RequestMethod.GET)
    String historial(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", ((User)auth.getPrincipal()).getUsername());

        String a = ((User)auth.getPrincipal()).getUsername();
        com.ucbcba.RegistroMedico.entities.User h = userService.findByUsername(a);

        model.addAttribute("h",h);

        return "miHistorial";
    }
    @RequestMapping(value = "/miHistorial/nuevoMedicamento", method = RequestMethod.GET)
    String nuevoMedicamento(Model model){
        model.addAttribute("medicamento",new RegistroMedico());
        return "nuevoMedicamento";
    }
    @RequestMapping(value = "/miHistorial/nuevoAnalisis", method = RequestMethod.GET)
    String nuevoAnalisis(Model model){
        model.addAttribute("analisis",new RegistroMedico());
        return "nuevoAnalisis";
    }
    @RequestMapping(value = "/miHistorial/nuevoTratamiento", method = RequestMethod.GET)
    String nuevoTratamiento(Model model){
        model.addAttribute("tratamiento",new RegistroMedico());
        return "nuevoTratamiento";
    }
    @RequestMapping(value = "/miHistorial/nuevaConsulta", method = RequestMethod.GET)
    String nuevaConsulta(Model model){
        model.addAttribute("consulta",new RegistroMedico());
        return "nuevaConsulta";
    }

    @RequestMapping(value = "/miHistorial/consulta", method = RequestMethod.POST)
    String saveC(@Valid RegistroMedico registroMedico, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "nuevaConsulta";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String a = ((User)auth.getPrincipal()).getUsername();
        com.ucbcba.RegistroMedico.entities.User h = userService.findByUsername(a);
        registroMedico.setUser(h);
        registroMedicoService.saveRegistroMedico(registroMedico);
        return "redirect:/miHistorial";
    }
    @RequestMapping(value = "/miHistorial/tratamiento", method = RequestMethod.POST)
    String saveT(@Valid RegistroMedico registroMedico, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "nuevoTratamiento";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String a = ((User)auth.getPrincipal()).getUsername();
        com.ucbcba.RegistroMedico.entities.User h = userService.findByUsername(a);
        registroMedico.setUser(h);
        registroMedicoService.saveRegistroMedico(registroMedico);
        return "redirect:/miHistorial";
    }
    @RequestMapping(value = "/miHistorial/analisis", method = RequestMethod.POST)
    String saveA(@Valid RegistroMedico registroMedico, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "nuevoAnalisis";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String a = ((User)auth.getPrincipal()).getUsername();
        com.ucbcba.RegistroMedico.entities.User h = userService.findByUsername(a);
        registroMedico.setUser(h);
        registroMedicoService.saveRegistroMedico(registroMedico);
        return "redirect:/miHistorial";
    }
    @RequestMapping(value = "/miHistorial/medicamento", method = RequestMethod.POST)
    String saveM(@Valid RegistroMedico registroMedico, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "nuevoMedicamento";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String a = ((User)auth.getPrincipal()).getUsername();
        com.ucbcba.RegistroMedico.entities.User h = userService.findByUsername(a);
        registroMedico.setUser(h);
        registroMedicoService.saveRegistroMedico(registroMedico);
        return "redirect:/miHistorial";
    }

    @RequestMapping(value = "/miHistorial/registroMedico", method = RequestMethod.POST)
    String saveRegistro(@Valid RegistroMedico registroMedico, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "editarRegistro" + registroMedico.getId();
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String a = ((User)auth.getPrincipal()).getUsername();
        com.ucbcba.RegistroMedico.entities.User h = userService.findByUsername(a);
        registroMedico.setUser(h);
        registroMedicoService.saveRegistroMedico(registroMedico);
        return "redirect:/miHistorial";
    }


    @GetMapping(value = "/miHistorial/mostrarRegistro/{id}")
    String mostrarRegistro(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash){
        RegistroMedico registroMedico = registroMedicoService.getRegistroMedico(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String a = ((User)auth.getPrincipal()).getUsername();
        com.ucbcba.RegistroMedico.entities.User h = userService.findByUsername(a);

        for(RegistroMedico registroMedicol : h.getRegistroMedicoList()){
            if(registroMedicol.getId() == registroMedico.getId()){
                model.addAttribute("registroMedico",registroMedico);
                model.addAttribute("observacion", new Observacion());
                model.addAttribute("fotoRegistro", new FotoRegistro());
                reg = registroMedico;
                return "mostrarRegistro";
            }
        }

        return "redirect:/miHistorial";
    }

    @RequestMapping("/miHistorial/editarRegistro/{id}")
    String editarRegistro(@PathVariable  Integer id, Model model){
        RegistroMedico registroMedico = registroMedicoService.getRegistroMedico(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String a = ((User)auth.getPrincipal()).getUsername();
        com.ucbcba.RegistroMedico.entities.User h = userService.findByUsername(a);

        for(RegistroMedico registroMedicol : h.getRegistroMedicoList()){
            if(registroMedicol.getId() == registroMedico.getId()){
                reg = registroMedico;
                model.addAttribute("registro", registroMedico);
                return "editarRegistro";
            }
        }
        return "redirect:/miHistorial";
    }

    @RequestMapping("/miHistorial/eliminarRegistro/{id}")
    String eliminarRegistro(@PathVariable Integer id){
        registroMedicoService.deleteRegistroMedico(id);
        return "redirect:/miHistorial";
    }

    @RequestMapping(value = "/miHistorial/subirFoto", method = RequestMethod.POST)
    String save(@Valid FotoRegistro fotoRegistro, @RequestParam("file") MultipartFile foto,
                BindingResult bindingResult, RedirectAttributes flash){
        fotoRegistro.setRegistroMedico(reg);
        if(!foto.isEmpty()){

            String uniqueFilename = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
            Path rootPath = Paths.get("uploads").resolve(uniqueFilename);

            Path rootAbsolutePath = rootPath.toAbsolutePath();


            try{
                Files.copy(foto.getInputStream(),rootAbsolutePath);
                
                flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename +"'");
                fotoRegistro.setFoto(uniqueFilename);
                fotoRegistroService.saveFotoRegistro(fotoRegistro);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return "redirect:/miHistorial/mostrarRegistro/" + fotoRegistro.getRegistroMedico().getId();
    }

    @RequestMapping(value = "/miHistorial/agregarObservacion", method = RequestMethod.POST)
    String save(@Valid Observacion observacion, BindingResult bindingResult, Model model){
        observacion.setRegistroMedico(reg);
        if(!observacion.getDescripcion().isEmpty()){
            java.util.Date d = new java.util.Date();
            java.sql.Date d2 = new java.sql.Date(d.getTime());
            observacion.setFecha(d2);
            observacionService.saveObservacion(observacion);
        }
        return "redirect:/miHistorial/mostrarRegistro/" + observacion.getRegistroMedico().getId();
    }

}
