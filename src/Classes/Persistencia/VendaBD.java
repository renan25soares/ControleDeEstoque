package Classes.Persistencia;

import Classes.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
     
        
        public void altera(Venda v) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE venda set data_venda=?, id_clientefk=?, id_produtofk=?"
                + "WHERE id=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"        
        stmt.setString(1, String.valueOf(v.getId_cliente()));
        stmt.setString(2, String.valueOf(v.getId_produto()));
        stmt.setString(3, (v.getData_venda()));
        

        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(4, v.getId());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
        
        
}
