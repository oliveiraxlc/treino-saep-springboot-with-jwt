package com.lacos.muller.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lacos.muller.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {

    @Query(value
            = "select at.id, at.data, at.crianca_id, at.usuario_id, al.nome as crianca_nome , "
            + "r.nome as pretendente_nome, r.cpf as pretendente_cpf from atendimento at "
            + "inner join crianca al on al.id = at.crianca_id "
            + "inner join pretendente r on r.id = al.pretendente_id "
            + "order by at.data;", nativeQuery = true
    )

    public List<Atendimento> listarAtendimentos();
}
