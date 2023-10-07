package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.PacienteDao;
import com.proyectoJava.proyecto.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private PacienteDao pacienteDao;

    /****** Vistas *********/
    @RequestMapping(value = "paciente/{cedula}", method = RequestMethod.GET)
    public Paciente getPaciente(@PathVariable Integer cedula){
        return pacienteDao.getPaciente(cedula);
    }

    @RequestMapping(value = "pacientes")
    public List<Paciente> getPaciente(){
        return pacienteDao.getPacientes();
    }

    @RequestMapping(value = "paciente/expediente")
    public List<Expediente> getPacienteExpediente(){
        return pacienteDao.getPacienteExpediente(UsuarioActivo.getCedula());
    }

    @RequestMapping(value = "paciente/agenda")
    public List<CitaAgendada> citasAgendadas(){
        return pacienteDao.citasAgendadas(UsuarioActivo.getCedula());
    }

    @RequestMapping(value = "paciente/citasdisponibles")
    public List<CitaDisponible> citasDisponibles(){
        return pacienteDao.citasDisponibles();
    }

    /****** Funciones *********/
    @RequestMapping(value = "/paciente/{id_cita_disponible}/sacarcita", method = RequestMethod.POST)
    public void sacarCita(@PathVariable Integer id_cita_disponible) {
        pacienteDao.sacarCita(UsuarioActivo.getCedula(), id_cita_disponible);
    }

}