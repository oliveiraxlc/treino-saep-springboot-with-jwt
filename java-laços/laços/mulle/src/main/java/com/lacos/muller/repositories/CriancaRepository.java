package com.lacos.muller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacos.muller.models.Crianca;

public interface CriancaRepository extends JpaRepository<Crianca, Integer> {}