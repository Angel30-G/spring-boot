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

    //Se obtiene a una persona por medio de su cedula
    @Override
    public Persona getPersona(Integer cedula) {
        return entityManager.find(Persona.class, cedula);
    }

    //Se retorna una lista de personas
    @Override
    public List<Persona> getPersonas() {
        String query = "FROM Persona";
        return entityManager.createQuery(query,Persona.class).getResultList();
    }

    //Se guarda a una persona en la base de datos por medio del merge
    @Override
    public void guardar(Persona persona) {
        entityManager.merge(persona);
    }

    //Se elimina a una persona de la base de datos
    @Override
    public void eliminar(Integer cedula) {
        Persona persona = entityManager.find(Persona.class, cedula);
        entityManager.remove(persona);
    }

}
