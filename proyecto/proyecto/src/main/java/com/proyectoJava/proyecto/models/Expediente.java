package com.proyectoJava.proyecto.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "expediente")
@ToString
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_expediente")
    private Integer id_expediente;

    @ManyToOne
    @JoinColumn(name = "cedula")
    @Getter @Setter
    private Paciente paciente;

    @Getter @Setter @Column(name = "fecha")
    private java.sql.Date fecha;

    @Getter @Setter @Column(name = "padecimiento")
    private String padecimiento;

    @Getter @Setter @Column(name = "procedimiento")
    private String procedimiento;

    @Getter @Setter @Column(name = "medicamentos")
    private String medicamentos;

}
