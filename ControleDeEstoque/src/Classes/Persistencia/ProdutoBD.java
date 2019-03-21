package Classes.Persistencia;

import Classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoBD {
    
    private Connection conexao;
    
    public ProdutoBD() throws SQLException {       
        this.conexao = ConexaoBD.getConexao();
    }
        
    public void adicionaProduto(Produto p) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO produto(descricao, preco)"
                + "VALUES(?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setString(1, p.getNome());
        stmt.setFloat(2, (float) p.getPreço());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
        }
    
        public void mostrarProdutos() throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM produto";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("ID:" + rs.getInt("id_produto") +" - Nome:"+ rs.getString("descricao")+" - Preço:"+ rs.getFloat("preco"));
        }
        stmt.close();
        
        }  
    
}
