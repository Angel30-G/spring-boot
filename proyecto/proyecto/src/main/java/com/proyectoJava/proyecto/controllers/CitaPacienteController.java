package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.CitaPacienteDao;
import com.proyectoJava.proyecto.dao.PacienteDao;
import com.proyectoJava.proyecto.models.CitaAgendada;
import com.proyectoJava.proyecto.models.CitaDisponible;
import com.proyectoJava.proyecto.models.Expediente;
import com.proyectoJava.proyecto.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitaPacienteController {

    @Autowired
    private CitaPacienteDao citaPacienteDao;

    @RequestMapping(value = "paciente/{cedula}/agenda")
    public List<CitaAgendada> citasAgendadas(@PathVariable Integer cedula){
        return citaPacienteDao.citasAgendadas(cedula);
    }

    @RequestMapping(value = "paciente/citasdisponibles")
    public List<CitaDisponible> citasDisponibles(){
        return citaPacienteDao.citasDisponibles();
    }

}