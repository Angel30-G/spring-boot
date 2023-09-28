package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Expediente;
import com.proyectoJava.proyecto.models.Paciente;
import com.proyectoJava.proyecto.models.Persona;
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

    @Override
    public Paciente getPaciente(Integer cedula) {
        return entityManager.find(Paciente.class, cedula);
    }

    @Override
    public List<Paciente> getPacientes() {
        String query = "FROM Paciente";
        return entityManager.createQuery(query, Paciente.class).getResultList();
    }

    @Override
    public List<Expediente> getPacienteExpediente(Integer cedula) {
        String query = "SELECT e FROM Expediente e WHERE e.paciente.cedula = :cedula";
        return entityManager.createQuery(query, Expediente.class)
                .setParameter("cedula", cedula)
                .getResultList();
    }

    @Override
    public void guardar(Paciente paciente) {
        entityManager.merge(paciente);
    }//Hace insert o update a BD

    @Override
    public void eliminar(Integer cedula) {
        Paciente paciente = entityManager.find(Paciente.class, cedula);
        entityManager.remove(paciente);
    }

}
