package com.proyectoJava.proyecto.models;

import lombok.Getter;
import lombok.Setter;

/*Clase para representar cual es el usuario activo despues de iniciar sesion*/
public abstract class UsuarioActivo {

    //Atributo de clase con la cedula del usuario activo
    private static Integer cedula;

    //Metodo de clase para obtener la cedula del usuario activo
    public static Integer getCedula() {
        return cedula;
    }

    //Metodo de clase para definir cual es la cedula del usuario activo
    public static void setCedula(Integer cedula) {
        UsuarioActivo.cedula = cedula;
    }

}
