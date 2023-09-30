package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.CitaAgendada;
import com.proyectoJava.proyecto.models.CitaDisponible;
import com.proyectoJava.proyecto.models.Expediente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CitaPacienteDaoImp implements CitaPacienteDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CitaAgendada> citasAgendadas(Integer cedula){
        String query = "SELECT ca FROM CitaAgendada ca WHERE ca.paciente.cedula = :cedula";
        return entityManager.createQuery(query, CitaAgendada.class)
                .setParameter("cedula", cedula)
                .getResultList();
    }

    @Override
    public List<CitaDisponible> citasDisponibles(){
        String query = "SELECT cd FROM CitaDisponible cd WHERE cd.medico.especialidad.id_especialidad = 1";
        return entityManager.createQuery(query, CitaDisponible.class).getResultList();
    }
}
