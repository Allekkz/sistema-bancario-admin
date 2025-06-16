/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;

import com.unincor.sistema.bancario.admin.configurations.MySQL;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class AgenciaDao {

    public void inserirAgencia(Agencia agencia) {
        String sql = "INSERT INTO agencias(codigo_agencia, cidade, uf, "
                + "logradouro, numero, cep) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, agencia.getCodigo_agencia());
            ps.setString(2, agencia.getCidade());
            ps.setString(3, agencia.getUf());
            ps.setString(4, agencia.getLogradouro());
            ps.setString(5, agencia.getNumero());
            ps.setString(6, agencia.getCep());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AgenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Buscar:
    public List<Agencia> listarTodasAgencias() {
        String sql = "SELECT * FROM Agencias";
        List<Agencia> agencias = new ArrayList<>();
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                agencias.add(construirAgenciaSql(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agencias;
    }

    public Agencia buscarAgenciaPorId(Long id) {
        String sql = "SELECT * FROM Agencias where id_agencia = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirAgenciaSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    // Buscar agencia pelo código // Teste, corrigir em aula:
        public Agencia buscarAgenciaPorCodigoAgencia(String codigoAgencia) {
        String sql = "SELECT * FROM Agencias where id_agencia = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigoAgencia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirAgenciaSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    // ==

    public Agencia construirAgenciaSql(ResultSet rs) throws SQLException {
        Agencia agencia = new Agencia();
        agencia.setIdAgencia(rs.getLong("id_agencia"));
        agencia.setCodigo_agencia(rs.getString("codigo_agencia"));
        agencia.setCidade(rs.getString("cidade"));
        agencia.setUf(rs.getString("uf"));
        agencia.setLogradouro(rs.getString("logradouro"));
        agencia.setNumero("numero");
        agencia.setCep(rs.getString("cep"));
        return agencia;
    }

    // Main: 
    public static void main(String[] args) {
        //Inserir agencia aqui:
        AgenciaDao agenciaDao = new AgenciaDao();

        Agencia agencia = new Agencia(null, "1", "sgs", "MG", "avenida flamboyant", "12", "3749");
        agenciaDao.inserirAgencia(agencia);

        List<Agencia> agencias = agenciaDao.listarTodasAgencias();
        agencias.forEach(ag -> System.out.println("Código: " + ag.getCodigo_agencia()));
        Agencia ag = agenciaDao.buscarAgenciaPorId(1l);
        if (ag != null) {
            System.out.println("Código: " + ag.getCodigo_agencia());
        }
    }
}
