package com.lacos.muller.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.lacos.muller.models.Pretendente;
import com.lacos.muller.sevices.PretendenteService;

@RestController
@RequestMapping("/Pretendente")
public class PretendenteController {

    private final PretendenteService pretendenteService;

    PretendenteController(PretendenteService pretendenteService) {
        this.pretendenteService = pretendenteService;
    }

    @GetMapping("/listar")
    public List<Pretendente> listarPretendentes(@RequestParam(required = true) String termo) {
        return pretendenteService.listarPretendentes(termo);
    }

    @GetMapping("/buscar/{id}")
    public Pretendente buscar(@PathVariable Integer id) {
        return pretendenteService.buscar(id);
    }

    @PostMapping("/salvar")
    public Pretendente salvar(@RequestBody Pretendente Pretendente) {
        return pretendenteService.salvar(Pretendente);
    }

    @PutMapping("/atualizar/{id}")
    public Pretendente atualizar(@RequestBody Pretendente Pretendente,
            @PathVariable Integer id) {
        return pretendenteService.atualizar(Pretendente, id);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        pretendenteService.deletar(id);
        return "Responsável deletado com sucesso";
    }
}