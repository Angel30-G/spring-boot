package com.proyectoJava.proyecto.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medico")
@PrimaryKeyJoinColumn(referencedColumnName = "cedula")
@ToString
@Getter
@Setter
/*Representa a la tabla Paciente de la base de datos, es subclase de Persona*/
public class Medico extends Persona {

    @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name="id_especialidad")
    private Especialidad especialidad;

}