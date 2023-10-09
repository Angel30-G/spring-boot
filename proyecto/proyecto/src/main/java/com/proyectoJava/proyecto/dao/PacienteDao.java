package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.CitaAgendada;
import com.proyectoJava.proyecto.models.CitaDisponible;
import com.proyectoJava.proyecto.models.Expediente;
import com.proyectoJava.proyecto.models.Paciente;

import java.util.List;

public interface PacienteDao {

    //Un metodo de tipo Paciente, que obtiene los pacientes por medio de la cedula
    Paciente getPaciente(Integer cedula);
    //Un metodo que genera retorna una lista de pacientes
    List<Paciente> getPacientes();
    //Un metodo que retorna una lista de expedientes tomando como referencia la cedula de un paciente
    List<Expediente> getPacienteExpediente(Integer cedula);
    //Guarda un paciente
    void guardar(Paciente paciente);

    //Elimina un paciente
    void eliminar(Integer cedula);

    //Un metodo que retorna una lista de citas agendadas
    List<CitaAgendada> citasAgendadas(Integer cedula);

    //Un metodo que retorna una lista de las citas disponibles
    List<CitaDisponible> citasDisponibles();

    //Permite sacar una cita que esta disponible
    void sacarCita(Integer cedula, Integer id_cita_disponible);

    //Cancela una cita por medio de su id
    void cancelarCita(Integer id_cita);

    //Verifica que se inicie sesion de manera correcta
    boolean iniciarSesionPaciente(Integer cedula, String contrasena);
}
