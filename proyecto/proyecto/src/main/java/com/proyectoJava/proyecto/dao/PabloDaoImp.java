package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Pablo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PabloDaoImp implements PabloDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Pablo> getPablos() {
        String query = "FROM Pablo";
        return entityManager.createQuery(query).getResultList();
    }
}
