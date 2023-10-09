package com.proyectoJava.proyecto.dao;

import com.proyectoJava.proyecto.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
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

    @Override
    public List<CitaAgendada> getMedicoAgenda(Integer cedula){
        String query = "SELECT ca FROM CitaAgendada ca WHERE ca.medico.cedula = :cedula";
        return entityManager.createQuery(query, CitaAgendada.class)
                .setParameter("cedula", cedula)
                .getResultList();
    }

    @Override
    public List<Paciente> getMedicoPacientes(Integer cedula){
        String query = "SELECT p FROM Paciente p WHERE p.medico_cabecera.cedula = :cedula";
        return entityManager.createQuery(query, Paciente.class)
                .setParameter("cedula", cedula)
                .getResultList();
    }

    @Override
    public List<CitaDisponible> medicoCitasDisponibles(){
        String query = "FROM CitaDisponible";
        return entityManager.createQuery(query, CitaDisponible.class).getResultList();
    }

    @Override
    public boolean iniciarSesionMedico(Integer cedula, String contrasena) {
        Medico medico = entityManager.find(Medico.class, cedula);
        if (medico == null){
            return false;
        } else{
            if(medico.getContrasena().equals(contrasena)){
                UsuarioActivo.setCedula(cedula);
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean referirPaciente(Integer cedula, Integer idCitaDisponible) {
        Paciente paciente = entityManager.find(Paciente.class, cedula);
        if (paciente == null){
            return false;
        }
        CitaDisponible citaDisponible = entityManager.find(CitaDisponible.class, idCitaDisponible);

        CitaAgendada citaAgendada = new CitaAgendada();

        citaAgendada.setPaciente(paciente);
        citaAgendada.setMedico(citaDisponible.getMedico());
        citaAgendada.setFecha(citaDisponible.getFecha());
        citaAgendada.setHora(citaDisponible.getHora());

        entityManager.merge(citaAgendada);
        entityManager.remove(citaDisponible);
        return true;
    }

    @Override
    public void escribirExpediente(Integer idCita, String padecimiento, String procedimiento, String medicamentos) {
        CitaAgendada citaAgendada = entityManager.find(CitaAgendada.class, idCita);
        if(citaAgendada == null || padecimiento == "" || procedimiento == "" || medicamentos == "") {
            return;
        }
        Paciente paciente = citaAgendada.getPaciente();
        LocalDate fecha = citaAgendada.getFecha();

        Expediente expediente = new Expediente();

        expediente.setPaciente(paciente);
        expediente.setFecha(fecha);
        expediente.setPadecimiento(padecimiento);
        expediente.setProcedimiento(procedimiento);
        expediente.setMedicamentos(medicamentos);

        entityManager.merge(expediente);
        entityManager.remove(citaAgendada);
    }

}
