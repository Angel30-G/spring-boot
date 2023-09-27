package com.proyectoJava.proyecto.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "pablo")
@ToString @EqualsAndHashCode
public class Pablo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Integer id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

}
