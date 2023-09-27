package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.PersonaDao;
import com.proyectoJava.proyecto.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaDao personaDao;

    @RequestMapping(value = "personas")
    public List<Persona> getPersonas(){
        return personaDao.getPersonas();
    }
}
