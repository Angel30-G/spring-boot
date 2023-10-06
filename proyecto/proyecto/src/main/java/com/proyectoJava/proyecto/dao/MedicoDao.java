package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.*;

import java.util.List;

public interface MedicoDao {

    Medico getMedico(Integer cedula);

    List<Medico> getMedicos();

    void guardar(Medico medico);

    void eliminar(Integer cedula);

    List<CitaAgendada> getMedicoAgenda(Integer cedula);

    List<Paciente> getMedicoPacientes(Integer cedula);

    List<CitaDisponible> medicoCitasDisponibles();
}