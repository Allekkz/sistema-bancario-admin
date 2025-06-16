/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.GerenteDao;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import com.unincor.sistema.bancario.admin.model.domain.Gerente;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class GerenteService {

    private final GerenteDao gerenteDao = new GerenteDao();

    public void salvarGerente(Gerente gerente) throws CadastroException {
        if (gerente.getNome() == null || gerente.getNome().isBlank()) {
            throw new CadastroException("Gerente não possui nome!");
        }

        // validar se a gerente esta com cidade e uf preenchido:
//        Gerente gerenteCidade = gerenteDao.buscarGerentePorCodigoGerente(gerente.getCidade());
//        Gerente gerenteUf = gerenteDao.buscarGerentePorCodigoGerente(gerente.getUf());
        if (gerente.getCpf() == null || gerente.getCpf().isBlank()) {
            throw new CadastroException("Gerente não possui CPF!");
        }
        if (gerente.getEmail() == null || gerente.getEmail().isBlank()) {
            throw new CadastroException("Gerente não informou e-mail para contato!");
        }

        gerenteDao.inserirGerente(gerente);
    }

    public List<Gerente> buscarGerente() {
        return gerenteDao.buscarTodosGerentes();
    }

    public static void main(String[] args) {
        GerenteService gerenteService = new GerenteService();

        Agencia agencia = new Agencia();
        agencia.setIdAgencia(5l);
        
        Gerente gerente = new Gerente(null, "Adalberto Costa", "9080999", LocalDate.now(),
                "adalberto.costa@gmail.com", "359888888888", "980272222", agencia);

        try {
            gerenteService.salvarGerente(gerente);
        } catch (CadastroException ex) {
            Logger.getLogger(GerenteService.class.getName()).log(Level.SEVERE, null, ex);
        
    }
}
}
