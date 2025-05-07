/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;

import com.unincor.sistema.bancario.admin.configuratios.MySQL;
import com.unincor.sistema.bancario.admin.model.domain.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class ClienteDao {
    
    public void inserirCliente(Cliente Cliente) {
        String sql = "INSERT INTO Clientes(nome, cpf, data_nascimento, "
                + "email, telefone, senha_rash) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection con = MySQL.connect();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Cliente.getNome());
            ps.setString(2, Cliente.getCpf());
            ps.setDate(3, Date.valueOf(Cliente.getDataNascimento()));
            ps.setString(4, Cliente.getEmail());
            ps.setString(5, Cliente.getTelefone());
            ps.setString(6, Cliente.getSenhaHash());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
