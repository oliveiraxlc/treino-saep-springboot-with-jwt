package com.lacos.muller.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.lacos.muller.dtos.LoginRequestDTO;
import com.lacos.muller.dtos.LoginResponseDTO;
import com.lacos.muller.models.Usuario;
import com.lacos.muller.sevices.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.cadastrar(usuario);
        return "Usuário cadastrado com sucesso";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
    try {
        LoginResponseDTO response = usuarioService.login(request);
    return ResponseEntity.ok(response);
    } catch (Exception e) {
    return ResponseEntity.status(401).body("Falha na autenticação: e-mail ou senha inválidos");
}
}

    @PostMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "Logout realizado com sucesso";
    }

    @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable Integer

    id) {
        return usuarioService.atualizar(usuario, id);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        usuarioService.deletar(id);
        return "Usuário deletado com sucesso";
    }

    @GetMapping("/buscar/{id}")
    public Usuario buscar(@PathVariable Integer id) {
        return usuarioService.buscar(id);
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}