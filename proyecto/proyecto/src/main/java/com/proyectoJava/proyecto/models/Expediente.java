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
/*Representa a la tabla expediente de la base de datos,
hay un expediente por cada cita en la que el paciente fue atendido
y contiene detalles sobre la atencion de esa cita*/
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_expediente")
    private Integer id_expediente;

    //Se asocian los expedientes a un paciente
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
