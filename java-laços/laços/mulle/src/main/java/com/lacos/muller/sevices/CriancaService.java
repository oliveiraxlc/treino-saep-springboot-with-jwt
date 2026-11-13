package com.lacos.muller.sevices;

import java.util.List;
import org.springframework.stereotype.Service;
import com.lacos.muller.models.Crianca;
import com.lacos.muller.repositories.CriancaRepository;

@Service
public class CriancaService {

    private final CriancaRepository criancaRepository;

    private final PretendenteService pretendenteService;

    CriancaService(CriancaRepository criancaRepository, PretendenteService pretendenteService) {
        this.criancaRepository = criancaRepository;
        this.pretendenteService = pretendenteService;
    }

    public Crianca cadastrar(Crianca crianca) {
        crianca.setPretendente(pretendenteService.buscar(crianca.getPretendente().getId()));
        return criancaRepository.save(crianca);
    }

    public Crianca atualizar(Crianca crianca, Integer id) {
        Crianca criancaExistente = buscar(id);
        if (criancaExistente == null) {
            throw new RuntimeException("Criancas não encontrado");
        }
    if (crianca.getNome() != null) {
            criancaExistente.setNome(crianca.getNome());
        }
        if (crianca.getPretendente() != null) {
            criancaExistente.setPretendente(pretendenteService.buscar(crianca.getPretendente().getId()));
        }return criancaRepository.save(criancaExistente);
    }

    public void deletar(Integer id) {
        criancaRepository.deleteById(id);
    }

    public Crianca buscar(Integer id) {
        return criancaRepository.findById(id).get();
    }

    public List<Crianca> listarCriancas() {
        return criancaRepository.findAll();
    }
}
