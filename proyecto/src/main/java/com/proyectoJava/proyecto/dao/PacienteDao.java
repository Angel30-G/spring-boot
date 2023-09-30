package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Expediente;
import com.proyectoJava.proyecto.models.Paciente;

import java.util.List;

public interface PacienteDao {

    Paciente getPaciente(Integer cedula);

    List<Paciente> getPacientes();

    List<Expediente> getPacienteExpediente(Integer cedula);

    void guardar(Paciente paciente);

    void eliminar(Integer cedula);
}
