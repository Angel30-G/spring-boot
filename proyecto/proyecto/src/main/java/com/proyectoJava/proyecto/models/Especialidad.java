package com.proyectoJava.proyecto.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialidad")
@ToString @EqualsAndHashCode
public class Especialidad {

    @Id
    @Getter @Setter @Column(name = "id_especialidad")
    private Integer id_especialidad;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    /*@OneToMany(mappedBy = "especialidad")
    @Getter @Setter
    private List<Medico> medicos;//Lista de medicos que tienen esta especialidad*/
}