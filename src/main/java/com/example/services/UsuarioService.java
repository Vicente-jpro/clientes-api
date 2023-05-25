package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.exceptions.DadosInvalidoException;
import com.example.models.Usuario;
import com.example.repositories.UsuarioRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        try {
            return this.usuarioRepository.save(usuario);
        } catch (Exception e) {
            log.error("Este email já se encontra em uso.");
            throw new DadosInvalidoException("Este email já se encontra em uso.");
        }

    }

    public Usuario findByEmail(String email) {
        return this.usuarioRepository.findByEmail(email);
    }

    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findByUsuarioById(Integer idUsuario) {
        return this.usuarioRepository
                .findById(idUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado id invalido: " + idUsuario));
    }

    public Usuario findByUsername(String username) {
        return this.usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email/Username invalido."));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.findByUsername(username);

        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPasswrd())
                .roles("USER")
                .build();
    }
}
