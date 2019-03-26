package Classes.Persistencia;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClienteBD {
    
    
    private Connection conexao;
    
    // Estabelece uma conexão
    public ClienteBD() throws SQLException {       
        this.conexao = ConexaoBD.getConexao();
    }
        
        
    
        public void adicionaCliente(Cliente c) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO cliente(nome, fone)"
                + "VALUES(?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getFone());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
        
        
        public List<Cliente> getLista() throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM cliente";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Cliente> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Cliente c = new Cliente();
            
            // "c" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
            c.setId(rs.getInt("id_cliente"));
            c.setNome(rs.getString("nome"));
            c.setFone(rs.getString("fone"));
            
            // Adiciona o registro na lista
            lista.add(c);            
        }
        
        
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
        
        

        public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM cliente WHERE id_cliente=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setInt(1, id);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();
        
    }    
        
        
        
        public void altera(Cliente c) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE cliente set nome=?, fone=?"
                + "WHERE id_cliente=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"        
        stmt.setString(1, String.valueOf(c.getNome()));
        stmt.setString(2, String.valueOf(c.getFone()));
        

        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(3, c.getId());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
        
        
}
