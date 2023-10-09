package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PacienteDaoImp implements PacienteDao {

    @PersistenceContext
    EntityManager entityManager;

    //Retorna todos los pacientes por medio de la cedula
    @Override
    public Paciente getPaciente(Integer cedula) {
        return entityManager.find(Paciente.class, cedula);
    }

    //Retorna la lista de pacientes guardados en la base de datos
    @Override
    public List<Paciente> getPacientes() {
        String query = "FROM Paciente";
        return entityManager.createQuery(query, Paciente.class).getResultList();
    }

    //Retorna una lista de expedientes utilizando la base de datos
    @Override
    public List<Expediente> getPacienteExpediente(Integer cedula) {
        String query = "SELECT e FROM Expediente e WHERE e.paciente.cedula = :cedula";
        return entityManager.createQuery(query, Expediente.class)
                .setParameter("cedula", cedula)
                .getResultList();
    }

    //Guarda un paciente utilizando un merge para agregarlo a la base de datos
    @Override
    public void guardar(Paciente paciente) {
        entityManager.merge(paciente);
    }//Hace insert o update a BD

    //Elimina un paciente de la base de datos
    @Override
    public void eliminar(Integer cedula) {
        Paciente paciente = entityManager.find(Paciente.class, cedula);
        entityManager.remove(paciente);
    }

    //Retorna una lista de citas agendadas llamandola desde la base de datos
    @Override
    public List<CitaAgendada> citasAgendadas(Integer cedula){
        String query = "SELECT ca FROM CitaAgendada ca WHERE ca.paciente.cedula = :cedula";
        return entityManager.createQuery(query, CitaAgendada.class)
                .setParameter("cedula", cedula)
                .getResultList();
    }

    //Retorna la lista de citas disponibles
    @Override
    public List<CitaDisponible> citasDisponibles(){
        String query = "SELECT cd FROM CitaDisponible cd WHERE cd.medico.especialidad.id_especialidad = 1";
        return entityManager.createQuery(query, CitaDisponible.class).getResultList();
    }

    //Permite sacar una cita que este disponible y reservarla
    @Override
    public void sacarCita(Integer cedula, Integer id_cita_disponible) {
        Paciente paciente = entityManager.find(Paciente.class, cedula);
        CitaDisponible citaDisponible = entityManager.find(CitaDisponible.class, id_cita_disponible);

        CitaAgendada citaAgendada = new CitaAgendada();

        citaAgendada.setPaciente(paciente);
        citaAgendada.setMedico(citaDisponible.getMedico());
        citaAgendada.setFecha(citaDisponible.getFecha());
        citaAgendada.setHora(citaDisponible.getHora());

        entityManager.merge(citaAgendada);
        entityManager.remove(citaDisponible);

    }

    //Permite cancelar una cita y desocupar el espacio
    @Override
    public void cancelarCita(Integer id_cita) {
        CitaAgendada citaAgendada = entityManager.find(CitaAgendada.class, id_cita);

        CitaDisponible citaDisponible = new CitaDisponible();
        citaDisponible.setMedico(citaAgendada.getMedico());
        citaDisponible.setFecha(citaAgendada.getFecha());
        citaDisponible.setHora(citaAgendada.getHora());

        entityManager.merge(citaDisponible);
        entityManager.remove(citaAgendada);
    }

    //Verifica que se haya iniciado sesión correctamente como paciente
    @Override
    public boolean iniciarSesionPaciente(Integer cedula, String contrasena) {
        Paciente paciente = entityManager.find(Paciente.class, cedula);
        if (paciente == null){
            return false;
        } else{
            if(paciente.getContrasena().equals(contrasena)){
                UsuarioActivo.setCedula(cedula);
                return true;
            }
            return false;
        }
    }

}
