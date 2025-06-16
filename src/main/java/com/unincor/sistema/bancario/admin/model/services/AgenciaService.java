/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.exceptions.CadastroException;
import com.unincor.sistema.bancario.admin.model.dao.AgenciaDao;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import java.util.List;

/**
 *
 * @author Alex
 */
public class AgenciaService {

    private final AgenciaDao agenciaDao = new AgenciaDao();

    public void salvarAgencia(Agencia agencia) throws CadastroException {
        if (agencia.getCodigo_agencia() == null || agencia.getCodigo_agencia().isBlank()) {
            throw new CadastroException("A agencia não possui um código agencia!");
        }

        Agencia agenciaBusca = agenciaDao.buscarAgenciaPorCodigoAgencia(agencia.getCodigo_agencia());
        if (agenciaBusca != null) {
            throw new CadastroException("Código agencia já cadastrado!");
        }

        // validar se a agencia esta com cidade e uf preenchido:
//        Agencia agenciaCidade = agenciaDao.buscarAgenciaPorCodigoAgencia(agencia.getCidade());
//        Agencia agenciaUf = agenciaDao.buscarAgenciaPorCodigoAgencia(agencia.getUf());
        if (agencia.getCidade() == null || agencia.getCidade().isBlank()) {
            throw new CadastroException("A agencia não possui uma Cidade informada");
        }
        if (agencia.getUf() == null || agencia.getUf().isBlank()) {
            throw new CadastroException("A agencia não possui uma UF informada");
        }

        agenciaDao.inserirAgencia(agencia);
    }
    
    public List<Agencia> buscarAgencia() {
        return agenciaDao.listarTodasAgencias();
    }

    public static void main(String[] args) {

    }

}
