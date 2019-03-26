package Classes.Persistencia;

import Classes.Cliente;
import Classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
        
        public List<Produto> getLista() throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM produto";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Produto> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Produto p = new Produto();
            // "c" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
            p.setId(rs.getInt("id_produto"));
            p.setNome(rs.getString("descricao"));
            p.setPreço(rs.getFloat("preco"));
            
            // Adiciona o registro na lista
            lista.add(p);            
        }
        
        
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    
    
        
        public void altera(Produto p) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE produto set descricao=?, preco=?"
                + "WHERE id_produto=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"        
        stmt.setString(1, p.getNome());
        stmt.setString(2, String.valueOf(p.getPreço()));

        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(3, p.getId());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
        
    
        public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM produto WHERE id_produto=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setInt(1, id);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();
        
    }
        
}
