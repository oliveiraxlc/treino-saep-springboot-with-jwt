package com.lacos.muller.dtos;

import java.time.LocalDate;

import com.lacos.muller.models.Crianca;

public class AtendimentoResponseDTO {
    private LocalDate data;
    private Crianca crianca;

    public AtendimentoResponseDTO() {
    }

    public AtendimentoResponseDTO(LocalDate data, Crianca crianca) {
        this.data = data;
        this.crianca = crianca;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }
}