package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.dao.PabloDao;
import com.proyectoJava.proyecto.dao.UsuarioDao;
import com.proyectoJava.proyecto.models.Pablo;
import com.proyectoJava.proyecto.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PabloController {
    @Autowired
    private PabloDao pabloDao;

    @RequestMapping(value = "pablos")
    public List<Pablo> getPablos(){
        return pabloDao.getPablos();
    }
}
