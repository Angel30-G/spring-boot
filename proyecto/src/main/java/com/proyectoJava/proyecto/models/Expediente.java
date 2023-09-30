package com.proyectoJava.proyecto.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "expediente")
@ToString
@Getter
@Setter
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_expediente")
    private Integer id_expediente;

    @ManyToOne
    @JoinColumn(name = "cedula")
    private Paciente paciente;

    @Column(name = "fecha")
    private java.time.LocalDate fecha;

    @Column(name = "padecimiento")
    private String padecimiento;

    @Column(name = "procedimiento")
    private String procedimiento;

    @Column(name = "medicamentos")
    private String medicamentos;

}
