package com.proyectoJava.proyecto.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
@ToString @EqualsAndHashCode
@Getter
@Setter
public class Persona {/*Representa a la tabla persona de la base de datos, es superclase de Paciente y Medico*/

    @Id
    @Column(name = "cedula")
    private Integer cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

}