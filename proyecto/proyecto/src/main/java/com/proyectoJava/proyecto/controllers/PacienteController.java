package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.PacienteDao;
import com.proyectoJava.proyecto.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private PacienteDao pacienteDao;

    @RequestMapping(value = "pacientes")
    public List<Paciente> getPaciente(){
        return pacienteDao.getPacientes();
    }
}