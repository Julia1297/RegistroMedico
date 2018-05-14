package com.ucbcba.RegistroMedico.controllers;

import com.ucbcba.RegistroMedico.entities.User;
import com.ucbcba.RegistroMedico.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registrationInit(Model model){
        model.addAttribute("user",new User());
        return "registration";

    }

    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration(@Valid User user, BindingResult bindingResult, Model model){
        user.setRole("ADMIN");
        if(bindingResult.hasErrors()){
            model.addAttribute(user);
            return "registration";
        }
        userService.save(user);
        return "redirect:/miHistorial";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        return "login";
    }
}
