package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.*;

import java.util.List;

public interface MedicoDao {

    //Recibe como parametro una cedula de tipo Integer para utilizar los datos de la base de datos
    Medico getMedico(Integer cedula);

    //Crea una metodo de tipo lista que esta compuesto por Medicos
    List<Medico> getMedicos();

    //Guarda un medico de tipo medico en la lista
    void guardar(Medico medico);

    //Elimina la cedula, siendo esta el indice principal del medico
    void eliminar(Integer cedula);

    //Se obtiene una lista de las citas agendadas de los medicos, teniendo como parametro su cedula
    List<CitaAgendada> getMedicoAgenda(Integer cedula);

    //Se obtiene una lista de las citas agendadas de los paciente, para relacionarla con los medicos
    List<Paciente> getMedicoPacientes(Integer cedula);

    //Muestra una lista de las citas disponibles de los medicos
    List<CitaDisponible> medicoCitasDisponibles();

    //Retorna un booleano, dependiendo de si los datos agregados son correctos en el inicio de sesion
    boolean iniciarSesionMedico(Integer cedula, String contrasena);

    //Retorna un booleano para indicar si es posible referir un paciente con un medico de cabecera
    boolean referirPaciente(Integer cedula, Integer idCitaDisponible);

    //Permite agregar un expediente, pero creado por el medico
    void escribirExpediente(Integer idCita, String padecimiento, String procedimiento, String medicamentos);
}