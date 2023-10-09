package com.proyectoJava.proyecto.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialidad")
@ToString
@EqualsAndHashCode
@Getter
@Setter
/*Representa a la tabla especialidad de la base de datos y tiene una relacion de uno a muchos con medico*/
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Integer id_especialidad;

    @Column(name = "nombre")
    private String nombre;

}