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
/*Representa la tabla CitaAgendada de la base de datos y representa las citas que ya fueron agendadas*/
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

    @Column(name = "fecha")
    private java.time.LocalDate fecha;

    @Column(name = "hora")
    private java.time.LocalTime hora;

}