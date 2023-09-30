package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.CitaDisponible;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CitaMedicoDaoImp {

    @PersistenceContext
    EntityManager entityManager;
    public List<CitaDisponible> citasDisponiblesPorEspecialidad(int idEspecialidad) {
        String query = "SELECT cd FROM CitaDisponible cd WHERE cd.medico.especialidad.id_especialidad = :idEspecialidad";
        return entityManager.createQuery(query, CitaDisponible.class)
                .setParameter("idEspecialidad", idEspecialidad)
                .getResultList();
    }
}
