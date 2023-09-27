package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Persona;

import java.util.List;

public interface PersonaDao {

    Persona getById(Integer cedula);

    List<Persona> getPersonas();

    void guardar(Persona persona);

    void eliminar(Integer cedula);
}
