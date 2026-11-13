package com.lacos.muller.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.lacos.muller.dtos.AtendimentoResponseDTO;
import com.lacos.muller.models.Atendimento;
import com.lacos.muller.sevices.AtendimentoService;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping("/listar")

    public List<AtendimentoResponseDTO> listarAtendimentos() {
        return atendimentoService.listarAtendimentos();
    }

    @GetMapping("/buscar/{id}")
    public AtendimentoResponseDTO buscarAtendimento(@PathVariable Integer id) {
        return atendimentoService.buscar(id);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarAtendimento(@PathVariable Integer id) {
        atendimentoService.deletar(id);
        return "Atendimento deletado com sucesso";
    }

    @PostMapping("/cadastrar")
    public String cadastrarAtendimento(@RequestBody Atendimento atendimento) {
        atendimentoService.cadastrar(atendimento);
        return "Atendimento cadastrado com sucesso";
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarAtendimento(@RequestBody Atendimento atendimento,
            @PathVariable Integer id) {
        atendimentoService.atualizar(atendimento, id);
        return "Atendimento atualizado com sucesso";
    }
}