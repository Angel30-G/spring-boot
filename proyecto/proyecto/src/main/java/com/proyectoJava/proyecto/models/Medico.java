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
public class Medico extends Persona {

    @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name="id_especialidad")
    private Especialidad especialidad;

}