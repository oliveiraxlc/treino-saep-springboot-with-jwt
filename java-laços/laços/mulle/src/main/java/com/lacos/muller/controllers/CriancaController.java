package com.lacos.muller.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lacos.muller.models.Crianca;
import com.lacos.muller.sevices.CriancaService;

@RestController
@RequestMapping("/crianca")
public class CriancaController {

    private final CriancaService criancaService;

    CriancaController(CriancaService criancaService) {
        this.criancaService = criancaService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Crianca> cadastrarCrianca(@RequestBody Crianca crianca) {
        Crianca criancaCadastrado = criancaService.cadastrar(crianca);
        return ResponseEntity.status(HttpStatus.CREATED).body(criancaCadastrado);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Crianca> atualizarCrianca(@RequestBody Crianca crianca,

    @PathVariable Integer id) {
        Crianca criancaAtualizado = criancaService.atualizar(crianca, id);
        return ResponseEntity.status(HttpStatus.OK).body(criancaAtualizado);
    }

    @DeleteMapping ("/deletar/{id}")
    public ResponseEntity<String> deletarCrianca(@PathVariable Integer id) {
    criancaService.deletar(id);
    return ResponseEntity.status(HttpStatus.OK).body("Crianca deletado com sucesso");
}

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Crianca> buscarCrianca(@PathVariable Integer id) {
        Crianca crianca = criancaService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(crianca);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Crianca>> listarCriancas() {
        List<Crianca> criancas = criancaService.listarCriancas();
        return ResponseEntity.status(HttpStatus.OK).body(criancas);
    }
}