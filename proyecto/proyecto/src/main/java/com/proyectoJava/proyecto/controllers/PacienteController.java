package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.PacienteDao;
import com.proyectoJava.proyecto.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*Contiene las funcionalidades relacionadas a los pacientes*/
@RestController
public class PacienteController {

    //Instancia de PacienteDao
    @Autowired
    private PacienteDao pacienteDao;

    /****** Vistas *********/
    //Muestra la informacion de un paciente segun su cedula
    @RequestMapping(value = "paciente/{cedula}", method = RequestMethod.GET)
    public Paciente getPaciente(@PathVariable Integer cedula){
        return pacienteDao.getPaciente(cedula);
    }

    //API para obtener la informacion de todos los pacientes de la base de datos
    @RequestMapping(value = "pacientes")
    public List<Paciente> getPaciente(){
        return pacienteDao.getPacientes();
    }

    //API que un paciente pueda ver su expediente
    @RequestMapping(value = "paciente/expediente")
    public List<Expediente> getPacienteExpediente(){
        return pacienteDao.getPacienteExpediente(UsuarioActivo.getCedula());
    }

    //API para que un paciente pueda ver su agenda
    @RequestMapping(value = "paciente/agenda")
    public List<CitaAgendada> citasAgendadas(){
        return pacienteDao.citasAgendadas(UsuarioActivo.getCedula());
    }

    //API para que un paciente pueda ver las citas disponibles de medicina general
    @RequestMapping(value = "paciente/citasdisponibles")
    public List<CitaDisponible> citasDisponibles(){
        return pacienteDao.citasDisponibles();
    }

    /****** Funciones *********/
    //API para agendar una cita de medicina general
    @RequestMapping(value = "paciente/{id_cita_disponible}/sacarcita", method = RequestMethod.POST)
    public void sacarCita(@PathVariable Integer id_cita_disponible) {
        pacienteDao.sacarCita(UsuarioActivo.getCedula(), id_cita_disponible);
    }

    //API para cancelar una cita agendada
    @RequestMapping(value = "paciente/{id_cita}/cancelarcita", method = RequestMethod.POST)
    public void cancelarCita(@PathVariable Integer id_cita) {
        pacienteDao.cancelarCita(id_cita);
    }

    //API para verificar el login del paciente
    @RequestMapping(value = "login/paciente")
    public boolean iniciarSesionPaciente(@RequestBody Map<String, String> datosInicioSesion){
        Integer cedula = Integer.parseInt(datosInicioSesion.get("cedula"));
        String contrasena = datosInicioSesion.get("contrasena");

        return pacienteDao.iniciarSesionPaciente(cedula, contrasena);
    }

}