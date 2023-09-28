package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Persona;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonaDaoImp implements PersonaDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Persona getById(Integer cedula) {
        return null;
    }

    @Override
    @Transactional
    public List<Persona> getPersonas() {
        String query = "FROM Persona";
        return entityManager.createQuery(query,Persona.class).getResultList();
    }

    @Override
    public void guardar(Persona persona) {
        entityManager.merge(persona);
    }

    @Override
    public void eliminar(Integer cedula) {
        Persona persona = entityManager.find(Persona.class, cedula);
        entityManager.remove(persona);
    }

}
