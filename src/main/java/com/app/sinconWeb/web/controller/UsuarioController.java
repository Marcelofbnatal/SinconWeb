/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.web.controller;

import com.app.sinconWeb.models.Usuario;
import com.app.sinconWeb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marcelo Fernandes
 */
@Controller //Define a classe como um bean do Spring
//@RequestMapping(path = "usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository ur; //Injeta a classe de serviços
    
   @RequestMapping(value="/cadastrarUsuarios" , method=RequestMethod.GET)
    public String form(){
        return "dashboard/usuario";
    }
    
    @RequestMapping(value="/cadastrarUsuarios" , method=RequestMethod.POST)
    public String form(Usuario usuario){
        ur.save(usuario);
        return "redirect:/cadastrarUsuarios";
    }
    
  
     @RequestMapping(path="usuarios")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("dashboard/listarUsuario");
        modelAndView.addObject("usuarios", ur.findAll());
        return modelAndView;
    }
    
}
