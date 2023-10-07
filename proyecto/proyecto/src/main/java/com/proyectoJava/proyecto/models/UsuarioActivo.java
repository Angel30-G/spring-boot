package com.proyectoJava.proyecto.models;

import lombok.Getter;
import lombok.Setter;


public abstract class UsuarioActivo {

    private static Integer cedula = 117790909;
    
    public static Integer getCedula() {
        return cedula;
    }

    public static void setCedula(Integer cedula) {
        UsuarioActivo.cedula = cedula;
    }

}
