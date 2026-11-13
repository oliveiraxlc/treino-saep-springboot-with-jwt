package com.lacos.muller.sevices;

import java.util.List;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lacos.muller.models.Pretendente;
import com.lacos.muller.repositories.PretendenteRepository;



@Service
public class PretendenteService {

    private final PretendenteRepository pretendenteRepository;
    private final PasswordEncoder passwordEncoder;

    PretendenteService(PretendenteRepository pretendenteRepository, PasswordEncoder passwordEncoder) {
        this.pretendenteRepository = pretendenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Pretendente> listarPretendentes(String termo) {
        return pretendenteRepository.listarPretendentes(termo);
    }

    public Pretendente buscar(Integer id) {
        return pretendenteRepository.findById(id).get();
    }

    public Pretendente salvar(Pretendente pretendente) {
        pretendente.setCpf(passwordEncoder.encode(pretendente.getCpf()));
        return pretendenteRepository.save(pretendente);

    }

    public Pretendente atualizar(Pretendente pretendente, Integer id) {
        Pretendente pretendenteExistente = buscar(id);
        if (pretendenteExistente == null) {
            throw new RuntimeException("Responsável não encontrado");
        }
        if (pretendente.getCpf() != null) {
            pretendenteExistente.setCpf(passwordEncoder.encode(pretendente.getCpf()));
        }
        if (pretendente.getNome() != null) {
            pretendenteExistente.setNome(pretendente.getNome());
        }
        return pretendenteRepository.save(pretendenteExistente);
    }

    public void deletar(Integer id) {
        pretendenteRepository.deleteById(id);
    }
}
