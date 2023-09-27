package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Paciente;

import java.util.List;

public interface PacienteDao {

    Paciente getById(Integer cedula);

    List<Paciente> getPacientes();

    void guardar(Paciente paciente);

    void eliminar(Integer cedula);
}
