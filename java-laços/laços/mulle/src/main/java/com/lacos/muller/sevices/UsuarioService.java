package com.lacos.muller.sevices;

import java.util.List;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lacos.muller.configs.JwtService;
import com.lacos.muller.dtos.LoginRequestDTO;
import com.lacos.muller.dtos.LoginResponseDTO;
import com.lacos.muller.models.Usuario;
import com.lacos.muller.repositories.UsuarioRepository;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authManager;

    private final PasswordEncoder passwordEncoder;

    UsuarioService(UsuarioRepository usuarioRepository, JwtService jwtService, AuthenticationManager authManager, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO login(LoginRequestDTO usuario) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha()));
        Usuario usuarioRetornado
                = usuarioRepository.findByEmail(usuario.getEmail()).orElseThrow();
        String token = jwtService.generateToken(usuarioRetornado.getEmail(),
                usuarioRetornado.getPerfil());
        return new LoginResponseDTO(usuarioRetornado.getEmail(),
                usuarioRetornado.getNome(), usuarioRetornado.getPerfil(), token);
    }

    public Usuario cadastrar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario, Integer id) {
        Usuario usuarioExistente = buscar(id);
        if (usuarioExistente == null) {
            throw new RuntimeException("Usuario não encontrado");
        }
    if (usuario.getNome() != null) {
            usuarioExistente.setNome(usuario.getNome());
        }
        if (usuario.getEmail() != null) {
            usuarioExistente.setEmail(usuario.getEmail());
        }
        if (usuario.getSenha() != null) {
            usuarioExistente.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }
        if (usuario.getPerfil() != null) {
            usuarioExistente.setPerfil(usuario.getPerfil());
        }
        return usuarioRepository.save(usuarioExistente);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario buscar(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
