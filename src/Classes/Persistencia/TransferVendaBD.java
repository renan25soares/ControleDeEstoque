package Classes.Persistencia;

import Classes.TransferVenda;
import Classes.Venda;
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
public class TransferVendaBD {
    
        private Connection conexao;
    
    // Estabelece uma conexão
    public TransferVendaBD() throws SQLException {       
        this.conexao = ConexaoBD.getConexao();
    }
    
            public List<TransferVenda> getLista() throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "select nome, descricao, id, data_venda\n" +
                     "from cliente, venda, produto p\n" +
                     "where id_cliente = id_clientefk and id_produto = id_produtofk";;
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<TransferVenda> lista = new ArrayList<>();

        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            TransferVenda v = new TransferVenda();

            // "c" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
            v.setId_venda(rs.getInt("id"));
            v.setNome_cliente(rs.getString("nome"));
            v.setProduto(rs.getString("descricao"));
            v.setData_venda(rs.getString("data_venda"));
            
            // Adiciona o registro na lista
            lista.add(v);
        }
        
        
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
}
