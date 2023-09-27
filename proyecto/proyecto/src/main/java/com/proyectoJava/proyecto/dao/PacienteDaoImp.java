package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Paciente;
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
    public Paciente getById(Integer cedula) {
        return null;
    }

    @Override
    @Transactional
    public List<Paciente> getPacientes() {
        String query = "FROM Paciente";
        return entityManager.createQuery(query).getResultList();
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
