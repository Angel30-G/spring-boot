package com.proyectoJava.proyecto.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cita_disponible")
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class CitaDisponible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita_disponible")
    private Integer id_cita_disponible;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;

    @Column(name = "fecha_hora")
    private java.time.LocalDateTime fecha_hora;

}
