package com.lacos.muller.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "perfil")
    private String perfil;

    @Column(name = "email")
    private String email;
    
    @Column(name = "senha")
    private String senha;

    public Usuario() {
    }

    public Usuario(String email, Integer id, String nome, String perfil, String senha) {
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.perfil = perfil;
        this.senha = senha;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

// CREATE TABLE usuarios (
//     id SERIAL PRIMARY KEY,
//     nome VARCHAR(100) NOT NULL,
//     email VARCHAR(100) UNIQUE NOT NULL,
//     senha VARCHAR(255) NOT null,
//     perfil varchar(50)
// );
