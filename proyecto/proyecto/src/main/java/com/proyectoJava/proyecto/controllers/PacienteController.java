package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.PacienteDao;
import com.proyectoJava.proyecto.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "paciente/{id_cita_disponible}/sacarcita", method = RequestMethod.POST)
    public void sacarCita(@PathVariable Integer id_cita_disponible) {
        pacienteDao.sacarCita(UsuarioActivo.getCedula(), id_cita_disponible);
    }

    @RequestMapping(value = "paciente/{id_cita}/cancelarcita", method = RequestMethod.POST)
    public void cancelarCita(@PathVariable Integer id_cita) {
        pacienteDao.cancelarCita(id_cita);
    }

    @RequestMapping(value = "login/paciente")
    public boolean iniciarSesionPaciente(@RequestBody Map<String, String> datosInicioSesion){
        Integer cedula = Integer.parseInt(datosInicioSesion.get("cedula"));
        String contrasena = datosInicioSesion.get("contrasena");

        return pacienteDao.iniciarSesionPaciente(cedula, contrasena);
    }

}