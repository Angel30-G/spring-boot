package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.MedicoDao;
import com.proyectoJava.proyecto.models.CitaAgendada;
import com.proyectoJava.proyecto.models.CitaDisponible;
import com.proyectoJava.proyecto.models.Medico;
import com.proyectoJava.proyecto.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private MedicoDao medicoDao;

    @RequestMapping(value = "medico/{cedula}", method = RequestMethod.GET)
    public Medico getMedico(@PathVariable Integer cedula){
        return medicoDao.getMedico(cedula);
    }

    @RequestMapping(value = "medicos")
    public List<Medico> getMedicos(){
        return medicoDao.getMedicos();
    }

    @RequestMapping(value = "medico/{cedula}/agenda", method = RequestMethod.GET)
    public List<CitaAgendada> getMedicoAgenda(@PathVariable Integer cedula){
        return medicoDao.getMedicoAgenda(cedula);
    }

    @RequestMapping(value = "medico/{cedula}/pacientes", method = RequestMethod.GET)
    public List<Paciente> getMedicoPacientes(@PathVariable Integer cedula){
        return medicoDao.getMedicoPacientes(cedula);
    }

    @RequestMapping(value = "medico/citasdisponibles")
    public List<CitaDisponible> citasDisponibles(){
        return medicoDao.medicoCitasDisponibles();
    }
}