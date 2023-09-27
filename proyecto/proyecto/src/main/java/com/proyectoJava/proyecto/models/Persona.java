package com.proyectoJava.proyecto.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
@ToString @EqualsAndHashCode
public class Persona {

    @Id
    @Getter @Setter @Column(name = "cedula")
    private Integer cedula;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "correo")
    private String correo;


}