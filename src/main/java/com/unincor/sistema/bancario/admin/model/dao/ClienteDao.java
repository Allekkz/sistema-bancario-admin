/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;

import com.unincor.sistema.bancario.admin.configurations.MySQL;
import com.unincor.sistema.bancario.admin.model.domain.Cliente;
import java.sql.Connection;
import java.sql.Date;
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
public class ClienteDao {

    public void inserirCliente(Cliente Cliente) {
        String sql = "INSERT INTO clientes(nome, cpf, data_nascimento, "
                + "email, telefone, senha_hash) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Cliente.getNome());
            ps.setString(2, Cliente.getCpf());
            ps.setDate(3, Date.valueOf(Cliente.getDataNascimento()));
            ps.setString(4, Cliente.getEmail());
            ps.setString(5, Cliente.getTelefone());
            ps.setString(6, Cliente.getSenhaHash());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> buscarTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                var cliente = construirClienteSql(rs);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }

    public Cliente buscarClientePorId(Long idCliente) {
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirClienteSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Cliente construirClienteSql(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getLong("id_cliente"));
        cliente.setNome(rs.getString("nome"));
        //novos:
        cliente.setCpf(rs.getString("cpf"));
        cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        cliente.setEmail(rs.getString("email"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setSenhaHash(rs.getString("senha_hash"));
        return cliente;
    }

    public static void main(String[] args) {
        //Inserir o cliente aqui depois...
//        Cliente cliente = new Cliente(null, "AlexPFCampos", "21324654", LocalDate.now(),
//               "alexpfc@gmail.com", "4564654897", "389102312749128903");
        ClienteDao clienteDao = new ClienteDao();
//        var clientes = clienteDao.buscarTodosClientes();
//        clientes.forEach(c -> System.out.println("ID: " + c.getIdCliente() + " Nome: " + c.getNome() + " Cpf: " + c.getCpf()
//                + " Data nascimento: " + c.getDataNascimento() + " Email: " + c.getEmail() + " telefone: " + c.getTelefone()
//                + " senha_hash: " + c.getSenhaHash()
//        ));
        
        var c = clienteDao.buscarClientePorId(1l);
        System.out.println("Id: " + c.getIdCliente()
                + " Nome: " + c.getNome());
        
    }
}
