package com.proyectoJava.proyecto.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "paciente")
@ToString
@PrimaryKeyJoinColumn(referencedColumnName = "cedula")
/*Representa a la tabla Paciente de la base de datos, es subclase de Persona*/
public class Paciente extends Persona {

    @Getter @Setter @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "medico_cabecera")
    @Getter @Setter
    private Medico medico_cabecera;


}