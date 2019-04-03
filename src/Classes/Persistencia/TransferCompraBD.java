/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Persistencia;

import Classes.TransferCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhdsd
 */
public class TransferCompraBD {
    
    private Connection conexao;
    
        public TransferCompraBD() throws SQLException {       
        this.conexao = ConexaoBD.getConexao();
    }
        
        
        public List<TransferCompra> getLista(String nome) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "select id, descricao, preco, data_venda\n" +
                     "from cliente, venda, produto p\n" +
                     "where id_cliente = id_clientefk and id_produto = id_produtofk and nome like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<TransferCompra> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            TransferCompra t = new TransferCompra();
            
            // "c" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
            t.setProduto(rs.getString("descricao"));
            t.setId_venda(Integer.valueOf(rs.getString("id")));
            t.setPreço(Double.valueOf(rs.getString("preco")));
            t.setData(rs.getString("data_venda"));
            
            // Adiciona o registro na lista
            lista.add(t);            
        }
        
    
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }

}