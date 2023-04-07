package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.exceptions.UsuarioNotFoundException;
import com.example.models.Usuario;
import com.example.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails autenticar(Usuario usuario) {
        UserDetails userDetails = this.loadUserByUsername(usuario.getUsername());
        // passwordEncoder.matches(senhaDigitada, senhaGravadaNoBD)
        boolean senhaCorreta = passwordEncoder.matches(usuario.getPasswrd(), userDetails.getPassword());

        if (senhaCorreta) {
            return userDetails;
        }

        throw new SenhaInvalidaException();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String[] usuarioRoles = usuario.isAdmin() ? new String[] { "ADMIN", "USER" } : new String[] { "USER" };

        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPasswrd())
                .roles(usuarioRoles)
                .build();
    }

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
