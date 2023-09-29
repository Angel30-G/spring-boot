package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.CitaDisponible;

import java.util.List;

public interface CitaMedicoDao {
    List<CitaDisponible> citasDisponiblesPorEspecialidad(Integer idEspecialidad);
}
