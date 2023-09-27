package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Medico;

import java.util.List;

public interface MedicoDao {

    Medico getById(Integer cedula);

    List<Medico> getMedicos();

    void guardar(Medico medico);

    void eliminar(Integer cedula);
}

