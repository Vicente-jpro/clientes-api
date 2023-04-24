package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.exceptions.UsuarioNotFoundException;
import com.example.models.Usuario;
import com.example.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findByUsuarioById(Integer idUsuario){
        return this.usuarioRepository
            .findById(idUsuario)
            .orElseThrow( ()-> new UsernameNotFoundException("Usuário não encontrado id invalido: "+idUsuario))
    }

    public Usuario findByUsername(String username){
        return this.usuarioRepository
            .findById(idUsuario)
            .orElseThrow( ()-> new UsernameNotFoundException("Usuário não encontrado id invalido: "+idUsuario))
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
