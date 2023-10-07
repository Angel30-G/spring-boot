package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.MedicoDao;
import com.proyectoJava.proyecto.models.*;
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

    @RequestMapping(value = "medico/agenda")
    public List<CitaAgendada> getMedicoAgenda(){
        return medicoDao.getMedicoAgenda(UsuarioActivo.getCedula());
    }

    @RequestMapping(value = "medico/pacientes")
    public List<Paciente> getMedicoPacientes(){
        return medicoDao.getMedicoPacientes(UsuarioActivo.getCedula());
    }

    @RequestMapping(value = "medico/citasdisponibles")
    public List<CitaDisponible> citasDisponibles(){
        return medicoDao.medicoCitasDisponibles();
    }


    @RequestMapping(value = "login/medico")
    public boolean iniciarSesionMedico(@RequestBody Map<String, String> datosInicioSesion){
        Integer cedula = Integer.parseInt(datosInicioSesion.get("cedula"));
        String contrasena = datosInicioSesion.get("contrasena");

        return medicoDao.iniciarSesionMedico(cedula, contrasena);
    }
}