package Classes.Persistencia;

import Classes.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaBD {
    
    private Connection conexao;
    
    public VendaBD() throws SQLException {       
        this.conexao = ConexaoBD.getConexao();
    }
    
    
     public void adicionaVenda(Venda v) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO venda(data_venda, id_clientefk, id_produtofk)"
                + "VALUES(?, ?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setString(1, v.getData_venda());
        stmt.setInt(2, (int) v.getId_cliente());
        stmt.setInt(3, (int) v.getId_produto());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
        }
     
        public void mostrarVendas() throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "select nome, descricao, id, data_venda\n" +
                     "from cliente, venda, produto p\n" +
                     "where id_cliente = id_clientefk and id_produto = id_produtofk";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("Cliente:" + rs.getString("nome") +" - Produto:"+ rs.getString("descricao")+" - ID:"+ rs.getInt("id") + " - Data da Venda:" + rs.getString("data_venda"));
        }
        stmt.close();
        
        }  
        
}
