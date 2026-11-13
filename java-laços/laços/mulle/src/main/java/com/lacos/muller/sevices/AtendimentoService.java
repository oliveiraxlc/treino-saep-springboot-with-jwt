package com.lacos.muller.sevices;

import java.util.List;
import org.springframework.stereotype.Service;

import com.lacos.muller.dtos.AtendimentoResponseDTO;
import com.lacos.muller.models.Atendimento;
import com.lacos.muller.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    private final CriancaService criancaService;
    
    private final UsuarioService usuarioService;

    AtendimentoService(AtendimentoRepository atendimentoRepository, CriancaService criancaService, UsuarioService usuarioService) {
        this.atendimentoRepository = atendimentoRepository;
        this.criancaService = criancaService;
        this.usuarioService = usuarioService;
    }

    public List<AtendimentoResponseDTO> listarAtendimentos() {
        return atendimentoRepository.listarAtendimentos()
                .stream()
                .map(atendimento -> new AtendimentoResponseDTO(
                        atendimento.getData(),
                        atendimento.getCrianca()))
                .toList();
    }

    public AtendimentoResponseDTO buscar(Integer id) {
        Atendimento atendimento = atendimentoRepository.findById(id).get();
        return new AtendimentoResponseDTO(atendimento.getData(),
                atendimento.getCrianca());
    }

    public void deletar(Integer id) {
        atendimentoRepository.deleteById(id);
    }

    public Atendimento cadastrar(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento atualizar(Atendimento atendimento, Integer id) {
        Atendimento atendimentoExistente = atendimentoRepository.findById(id).get();
        if (atendimentoExistente == null)
            throw new RuntimeException("Atendimento não encontrado");

        if (atendimento.getData() != null)
            atendimentoExistente.setData(atendimento.getData());
        if (atendimento.getCrianca() != null)
            atendimentoExistente.setCrianca(criancaService.buscar(atendimento.getCrianca().getId()));
        if (atendimento.getUsuario() != null)
            atendimentoExistente.setUsuario(usuarioService.buscar(atendimento.getUsuario().getId()));

        return atendimentoRepository.save(atendimentoExistente);
    }
}
