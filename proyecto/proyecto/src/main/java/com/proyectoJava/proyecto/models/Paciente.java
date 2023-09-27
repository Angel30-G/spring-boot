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
public class Paciente extends Persona {

    @Getter @Setter @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    @Getter @Setter
    private Medico medico_cabecera;

    /*@OneToMany(mappedBy = "paciente")
    @Getter @Setter
    private List<Expediente> expedientes;*/

}