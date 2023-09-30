package com.proyectoJava.proyecto.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cita_agendada")
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class CitaAgendada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer id_cita;

    @ManyToOne
    @JoinColumn(name="cedula")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;

    @Column(name = "fecha_hora")
    private java.time.LocalDateTime fecha_hora;

}