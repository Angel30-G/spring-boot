package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.MedicoDao;
import com.proyectoJava.proyecto.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*Contiene las funcionalidades relacionadas a los medicos*/
@RestController
public class MedicoController {

    //Instancia de Medico Dao
    @Autowired
    private MedicoDao medicoDao;

    /*** Vistas ***/
    //API para obtener la informacion del medico por su cedula
    @RequestMapping(value = "medico/{cedula}", method = RequestMethod.GET)
    public Medico getMedico(@PathVariable Integer cedula){
        return medicoDao.getMedico(cedula);
    }

    //API para obtener la informacion de todos los medicos de la base de datos
    @RequestMapping(value = "medicos")
    public List<Medico> getMedicos(){
        return medicoDao.getMedicos();
    }

    //API para que un medico pueda ver su agenda segun su usuario
    @RequestMapping(value = "medico/agenda")
    public List<CitaAgendada> getMedicoAgenda(){
        return medicoDao.getMedicoAgenda(UsuarioActivo.getCedula());
    }

    //API para que un medico pueda ver sus pacientes
    @RequestMapping(value = "medico/pacientes")
    public List<Paciente> getMedicoPacientes(){
        return medicoDao.getMedicoPacientes(UsuarioActivo.getCedula());
    }

    //API para que un medico pueda ver las citas disponibles de todas las especialidades y asi referir un paciente
    @RequestMapping(value = "medico/citasdisponibles")
    public List<CitaDisponible> citasDisponibles(){
        return medicoDao.medicoCitasDisponibles();
    }

    /*** Funciones ***/
    //API para verificar el login del medico
    @RequestMapping(value = "login/medico")
    public boolean iniciarSesionMedico(@RequestBody Map<String, String> datosInicioSesion){
        Integer cedula = Integer.parseInt(datosInicioSesion.get("cedula"));
        String contrasena = datosInicioSesion.get("contrasena");

        return medicoDao.iniciarSesionMedico(cedula, contrasena);
    }

    //API para referir un paciente con otro medico o especialista, retorna confirmacion de si se pudo referir
    @RequestMapping(value = "medico/referirpaciente", method = RequestMethod.POST)
    public boolean referirPaciente(@RequestBody Map<String, String> datosCita) {
        Integer cedula = Integer.parseInt(datosCita.get("cedula"));
        Integer id_cita_disponible = Integer.parseInt(datosCita.get("id_cita_disponible"));

        return medicoDao.referirPaciente(cedula, id_cita_disponible);
    }

    //API para dar por atendida la cita y escribir en el expediente del paciente
    @RequestMapping(value = "medico/escribirExpediente", method = RequestMethod.POST)
    public void escribirExpediente(@RequestBody Map<String, String> datosExpediente) {

        Integer idCita = Integer.parseInt(datosExpediente.get("idCita"));
        String padecimiento = datosExpediente.get("padecimiento");
        String procedimiento = datosExpediente.get("procedimiento");
        String medicamentos = datosExpediente.get("medicamentos");

        medicoDao.escribirExpediente(idCita, padecimiento, procedimiento, medicamentos);
    }
}