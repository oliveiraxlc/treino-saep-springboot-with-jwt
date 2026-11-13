package com.lacos.muller.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lacos.muller.models.Pretendente;



public interface PretendenteRepository extends JpaRepository<Pretendente, Integer> {

    @Query(value = "select * from pretendente where nome like '%'||:termo||'%';",
            nativeQuery = true)
    public List<Pretendente> listarPretendentes(String termo);
}
