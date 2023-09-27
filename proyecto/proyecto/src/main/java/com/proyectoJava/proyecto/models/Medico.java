package com.proyectoJava.proyecto.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medico")
@ToString
@PrimaryKeyJoinColumn(referencedColumnName = "cedula")
public class Medico extends Persona {

    @Getter @Setter @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    @Getter @Setter
    private Especialidad especialidad;

    /*@OneToMany(mappedBy = "medico_cabecera")
    @Getter @Setter
    private List<Paciente> pacientes;//Pacientes de los que este medico es el medico de cabecera*/

}