package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.CitaAgendada;
import com.proyectoJava.proyecto.models.CitaDisponible;

import java.util.List;

public interface CitaPacienteDao {

    List<CitaAgendada> citasAgendadas(Integer cedula);

    List<CitaDisponible> citasDisponibles();
}
