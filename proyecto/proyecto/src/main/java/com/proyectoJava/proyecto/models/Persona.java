package com.proyectoJava.proyecto.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
@ToString @EqualsAndHashCode
@Getter
@Setter
public class Persona {

    @Id
    @Column(name = "cedula")
    private int cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

}