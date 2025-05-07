/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

import java.time.LocalDate;

/**
 *
 * @author Alex
 */
public class Gerente extends Pessoa {
    private Long idGerente;
    private Agencia Agencia;
    
    public Gerente() {
        
    }

    public Gerente(Long idGerente, String nome, String cpf, LocalDate dataNascimento, String email, String telefone, String senhaHash, Agencia Agencia) {
        this.idGerente = idGerente;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senhaHash = senhaHash;
        this.Agencia = Agencia;
    }

    public Long getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }

    public Agencia getAgencia() {
        return Agencia;
    }

    public void setAgencia(Agencia Agencia) {
        this.Agencia = Agencia;
    }

}
