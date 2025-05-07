/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

/**
 *
 * @author Alex
 */
public class Agencia {
    private Long idAgencia;
    private String codigo_agencia;
    private String cidade;
    private String uf;
    private String logradouro;
    private String numero;
    private String cep;
    
    public Agencia() {
        
    }

    public Agencia(Long idAgencia, String codigo_agencia, String cidade, String uf, String logradouro, String numero, String cep) {
        this.idAgencia = idAgencia;
        this.codigo_agencia = codigo_agencia;
        this.cidade = cidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }

    public Long getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Long idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getCodigo_agencia() {
        return codigo_agencia;
    }

    public void setCodigo_agencia(String codigo_agencia) {
        this.codigo_agencia = codigo_agencia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
