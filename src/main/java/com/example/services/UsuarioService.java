package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.models.Usuario;
import com.example.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll();
    }

    public UserDetails loadUserByUsername(String loginUsuario) {
        return null;
    }
}
