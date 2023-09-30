package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.MedicoDao;
import com.proyectoJava.proyecto.models.Medico;
import com.proyectoJava.proyecto.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private MedicoDao medicoDao;

    @RequestMapping(value = "medico/{cedula}")
    public Medico getMedico(@PathVariable Integer cedula){
        return medicoDao.getMedico(cedula);
    }

    @RequestMapping(value = "medicos")
    public List<Medico> getMedico(){
        return medicoDao.getMedicos();
    }
}