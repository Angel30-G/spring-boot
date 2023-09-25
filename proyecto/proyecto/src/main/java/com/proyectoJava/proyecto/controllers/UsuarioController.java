package com.proyectoJava.proyecto.controllers;

import com.proyectoJava.proyecto.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Juan");
        usuario.setApellido("Rodriguez");
        usuario.setTelefono("87289010");
        usuario.setEmail("juanro30@gmail.com");
        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(234L);
        usuario.setNombre("Juan");
        usuario.setApellido("Rodriguez");
        usuario.setTelefono("87289010");
        usuario.setEmail("juanro30@gmail.com");

        Usuario usuario2 = new Usuario();
        usuario2.setId(345L);
        usuario2.setNombre("Maria");
        usuario2.setApellido("Gonzalez");
        usuario2.setTelefono("86778909");
        usuario2.setEmail("marian40@gmail.com");

        Usuario usuario3 = new Usuario();
        usuario3.setId(567L);
        usuario3.setNombre("Pablo");
        usuario3.setApellido("Vargas");
        usuario3.setTelefono("67892890");
        usuario3.setEmail("pablo50@gmail.com");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }

    @RequestMapping(value = "usuario1")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Rodriguez");
        usuario.setTelefono("87289010");
        usuario.setEmail("juanro30@gmail.com");
        return usuario;
    }

    @RequestMapping(value = "usuario2")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Rodriguez");
        usuario.setTelefono("87289010");
        usuario.setEmail("juanro30@gmail.com");
        return usuario;
    }

    @RequestMapping(value = "usuario3")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Rodriguez");
        usuario.setTelefono("87289010");
        usuario.setEmail("juanro30@gmail.com");
        return usuario;
    }
}
