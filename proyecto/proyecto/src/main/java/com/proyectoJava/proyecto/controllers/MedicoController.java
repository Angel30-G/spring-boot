package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.MedicoDao;
import com.proyectoJava.proyecto.models.CitaAgendada;
import com.proyectoJava.proyecto.models.CitaDisponible;
import com.proyectoJava.proyecto.models.Medico;
import com.proyectoJava.proyecto.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @RequestMapping(value = "login/medico", method = RequestMethod.POST)
    public boolean iniciarSesionMedico(@RequestBody Map<String, String> datosInicioSesion){
        Integer cedula = Integer.parseInt(datosInicioSesion.get("cedula"));
        String contrasena = datosInicioSesion.get("contrasena");

        return medicoDao.iniciarSesionMedico(cedula, contrasena);
    }
}