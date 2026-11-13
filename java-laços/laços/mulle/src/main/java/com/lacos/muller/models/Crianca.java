package com.lacos.muller.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "crianca")
public class Crianca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pretendente_id")
    private Pretendente pretendente;

    public Crianca() {
    }

    public Crianca(Integer id, String nome, Pretendente pretendente) {
        this.id = id;
        this.nome = nome;
        this.pretendente = pretendente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pretendente getPretendente() {
        return pretendente;
    }

    public void setPretendente(Pretendente pretendente) {
        this.pretendente = pretendente;
    }
}