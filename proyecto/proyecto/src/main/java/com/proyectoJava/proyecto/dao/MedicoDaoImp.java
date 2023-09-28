package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.Medico;
import com.proyectoJava.proyecto.models.Paciente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MedicoDaoImp implements MedicoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Medico getMedico(Integer cedula) {
        return entityManager.find(Medico.class, cedula);
    }

    @Override
    @Transactional
    public List<Medico> getMedicos() {
        String query = "FROM Medico";
        return entityManager.createQuery(query, Medico.class).getResultList();
    }

    @Override
    public void guardar(Medico medico) {
        entityManager.merge(medico);
    }

    @Override
    public void eliminar(Integer cedula) {
        Medico medico = entityManager.find(Medico.class, cedula);
        entityManager.remove(medico);
    }

}
