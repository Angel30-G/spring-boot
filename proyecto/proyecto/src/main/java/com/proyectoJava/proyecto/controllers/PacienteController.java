package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.PacienteDao;
import com.proyectoJava.proyecto.models.CitaAgendada;
import com.proyectoJava.proyecto.models.CitaDisponible;
import com.proyectoJava.proyecto.models.Expediente;
import com.proyectoJava.proyecto.models.Paciente;
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

    @RequestMapping(value = "paciente/{cedula}/expediente", method = RequestMethod.GET)
    public List<Expediente> getPacienteExpediente(@PathVariable Integer cedula){
        return pacienteDao.getPacienteExpediente(cedula);
    }

    @RequestMapping(value = "paciente/{cedula}/agenda", method = RequestMethod.GET)
    public List<CitaAgendada> citasAgendadas(@PathVariable Integer cedula){
        return pacienteDao.citasAgendadas(cedula);
    }

    @RequestMapping(value = "paciente/citasdisponibles")
    public List<CitaDisponible> citasDisponibles(){
        return pacienteDao.citasDisponibles();
    }

    /****** Funciones *********/
    @RequestMapping(value = "/paciente/{cedula}/{id_cita_disponible}/sacarcita", method = RequestMethod.POST)
    public void sacarCita(@PathVariable Integer cedula, @PathVariable Integer id_cita_disponible) {
        pacienteDao.sacarCita(cedula, id_cita_disponible);
    }

}