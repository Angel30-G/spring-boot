package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Persona;

import java.util.List;

public interface PersonaDao {

    //Crea una entidad con una cedula
    Persona getPersona(Integer cedula);

    //Lista de personas
    List<Persona> getPersonas();

    //Guarda a una persona
    void guardar(Persona persona);

    //Elimina a una persona
    void eliminar(Integer cedula);
}
