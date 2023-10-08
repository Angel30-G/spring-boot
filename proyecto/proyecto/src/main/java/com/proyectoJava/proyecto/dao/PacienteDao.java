package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.CitaAgendada;
import com.proyectoJava.proyecto.models.CitaDisponible;
import com.proyectoJava.proyecto.models.Expediente;
import com.proyectoJava.proyecto.models.Paciente;

import java.util.List;

public interface PacienteDao {

    Paciente getPaciente(Integer cedula);

    List<Paciente> getPacientes();

    List<Expediente> getPacienteExpediente(Integer cedula);

    void guardar(Paciente paciente);

    void eliminar(Integer cedula);

    List<CitaAgendada> citasAgendadas(Integer cedula);

    List<CitaDisponible> citasDisponibles();

    void sacarCita(Integer cedula, Integer id_cita_disponible);

    boolean iniciarSesionPaciente(Integer cedula, String contrasena);
}
